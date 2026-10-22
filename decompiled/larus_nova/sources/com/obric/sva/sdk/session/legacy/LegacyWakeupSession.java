package com.obric.sva.sdk.session.legacy;

import android.content.Context;
import android.os.Build;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.obric.sva.framework.api.ISvaFrameworkKt;
import com.obric.sva.framework.wrapper.IdentityWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerModuleWrapper;
import com.obric.sva.framework.wrapper.SoundTriggerWrapper;
import com.obric.sva.sdk.config.Stage1Config;
import com.obric.sva.sdk.controller.ExtendedSmMgr;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.data.IExtendedSmModel;
import com.obric.sva.sdk.data.IKeyphraseModel;
import com.obric.sva.sdk.data.IUserModel;
import com.obric.sva.sdk.data.SettingsModel;
import com.obric.sva.sdk.session.IWakeupSession;
import com.obric.sva.sdk.session.OpaqueDataHelper;
import com.obric.sva.sdk.session.SessionType;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.suite.lark.platform.component.dyres.DyResUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import rna.c;

/* JADX INFO: loaded from: classes6.dex */
public abstract class LegacyWakeupSession implements IWakeupSession {
    protected String TAG;
    private final Object mAttachLock;
    protected Context mContext;
    protected ExtendedSmMgr mExtendedSmMgr;
    protected boolean mIsSupportConcurrency;
    protected String mKeyphraseFromXml;
    protected String mLastStage1UserConfig;
    protected byte[] mOpaqueDataFromXml;
    protected SoundTriggerModuleWrapper mSTModule;
    protected UUID mVendorUuid;
    protected UUID mVendorUuidFromHal;
    protected List<IWakeupListener> mWakeupListeners;
    protected SoundTriggerWrapper.StatusListenerWrapper statusListenerWrapper;

    /* JADX INFO: renamed from: com.obric.sva.sdk.session.legacy.LegacyWakeupSession$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes34.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$sva$sdk$data$IExtendedSmModel$SessionStatus = null;

        static {
            int[] r100 = new int[IExtendedSmModel.SessionStatus.values().length];
            $SwitchMap$com$obric$sva$sdk$data$IExtendedSmModel$SessionStatus = r100;
            r100[IExtendedSmModel.SessionStatus.UNLOADED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$obric$sva$sdk$data$IExtendedSmModel$SessionStatus[IExtendedSmModel.SessionStatus.STARTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$sva$sdk$data$IExtendedSmModel$SessionStatus[IExtendedSmModel.SessionStatus.LOADED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$sva$sdk$data$IExtendedSmModel$SessionStatus[IExtendedSmModel.SessionStatus.STOPPED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static /* synthetic */ void a(LegacyWakeupSession r100) {
        r100.lambda$new$0();
    }

    public static /* synthetic */ void b(LegacyWakeupSession r100, SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper r101) {
        r100.lambda$startRecognition$1(r101);
    }

    public abstract int getModelIndex();

    public abstract String getModelUuid();

    private boolean attachModule() {
        Object r100 = this.mAttachLock;
        monitor-enter(r100);
    L40:
        th = move-exception;
        throw th;
    L5:
        if (this.mSTModule == null) goto L9;
        LogUtils.d(this.TAG, "attachModule: already attached", new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r100);     // Catch: Throwable -> L40
        return true;
    L9:
        String r101 = Build.MODEL;     // Catch: Throwable -> L40
        LogUtils.d(this.TAG, "attachModule: build model name = " + r101, new Object[0]);     // Catch: Throwable -> L40
        LogUtils.d(this.TAG, "attachModule start ### with packageName:" + this.mContext.getPackageName(), new Object[0]);     // Catch: Throwable -> L40
        ArrayList<SoundTriggerWrapper.ModulePropertiesWrapper> r102 = new ArrayList();     // Catch: Throwable -> L40
        IdentityWrapper r103 = new IdentityWrapper();     // Catch: Throwable -> L40
        r103.setPackageName(this.mContext.getPackageName());     // Catch: Throwable -> L40
        ISvaFrameworkKt.getSvaFrameworkDelegate().listModulesAsOriginator(r102, r103);     // Catch: Throwable -> L40
        if (r102.isEmpty() == false) goto L14;
        LogUtils.e(this.TAG, "attachModule: no available modules", new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r100);     // Catch: Throwable -> L40
        return false;
    L14:
        LogUtils.d(this.TAG, "attachModule all module properties size is :  " + r102.size(), new Object[0]);     // Catch: Throwable -> L40
        Iterator<SoundTriggerWrapper.ModulePropertiesWrapper> r104 = r102.iterator();     // Catch: Throwable -> L40
    L16:
        if (r104.hasNext() == false) goto L19;
        SoundTriggerWrapper.ModulePropertiesWrapper r105 = r104.next();     // Catch: Throwable -> L40
        LogUtils.d(this.TAG, "attachModule: each moduleProperty = " + r105 + "\n", new Object[0]);     // Catch: Throwable -> L40
        goto L16
    L19:
        if (getModelIndex() < r102.size()) goto L23;
        LogUtils.e(this.TAG, "attachModule: out of bound of model size " + r102.size(), new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r100);     // Catch: Throwable -> L40
        return false;
    L23:
        SoundTriggerWrapper.ModulePropertiesWrapper r106 = r102.get(getModelIndex());     // Catch: Throwable -> L40
        String r107 = getModelUuid();     // Catch: Throwable -> L40
        if (r107 != null) goto L43;
        LogUtils.e(this.TAG, "attachModule: modelUuid is null", new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r100);     // Catch: Throwable -> L40
        return false;
    L43:
        this.mVendorUuidFromHal = UUID.fromString(r107);     // Catch: IllegalArgumentException -> L37 Throwable -> L40
        this.mIsSupportConcurrency = r106.isConcurrentCaptureSupported();     // Catch: Throwable -> L40
        LogUtils.d(this.TAG, "attachModule: moduleProperties:" + r106 + ", mIsSupportConcurrency = " + this.mIsSupportConcurrency, new Object[0]);     // Catch: Throwable -> L40
        SoundTriggerModuleWrapper r108 = ISvaFrameworkKt.getSvaFrameworkDelegate().attachModuleAsOriginator(r106.getId(), this.statusListenerWrapper, null, r103);     // Catch: Throwable -> L40
        this.mSTModule = r108;     // Catch: Throwable -> L40
        if (r108 != null) goto L34;
        LogUtils.e(this.TAG, "attachModule: low layer error", new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r100);     // Catch: Throwable -> L40
        return false;
    L34:
        LogUtils.e(this.TAG, "attachModule attached: successful", new Object[0]);     // Catch: Throwable -> L40
        monitor-exit(r100);     // Catch: Throwable -> L40
        return true;
    L37:
        LogUtils.e(this.TAG, "attachModule: invalid UUID format: " + maskTailForLog(r107), new Object[0]);     // Catch: Throwable -> L40
        return false;
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public boolean isSupportConcurrency() {
        if (this.mSTModule != null) goto L8;
        if (attachModule() == true) goto L8;
        this.mIsSupportConcurrency = false;
    L8:
        return this.mIsSupportConcurrency;
    }

    public void onResourcesAvailableWrapper() {
        LogUtils.d(this.TAG, "onResourcesAvailable", new Object[0]);
        Iterator<IWakeupListener> r100 = this.mWakeupListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onResourcesAvailable(getSessionType());
        goto L4
    }

    public void onServiceDiedWrapper() {
        LogUtils.d(this.TAG, "onServiceDied: ST Service died", new Object[0]);
        Iterator<IWakeupListener> r100 = this.mWakeupListeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onServiceDied(getSessionType());
        goto L4
    L6:
        releaseAllSvaSessions();
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public void releaseAllSvaSessions() {
        LogUtils.d(this.TAG, "@@ releaseAllSvaSessions @@", new Object[0]);
        Iterator<IExtendedSmModel> r100 = this.mExtendedSmMgr.getAllSoundModelList().iterator();
    L4:
        if (r100.hasNext() == false) goto L19;
        IExtendedSmModel r101 = r100.next();
        String r102 = r101.getSoundModelFullFileName();
        LogUtils.d(this.TAG, "releaseAllSvaSessions: smName = " + r102, new Object[0]);
        int r103 = AnonymousClass2.$SwitchMap$com$obric$sva$sdk$data$IExtendedSmModel$SessionStatus[r101.getSessionStatus().ordinal()];
        if (r103 != 1) goto L8;
        LogUtils.d(this.TAG, "releaseAllSvaSessions: unloaded status, do nothing", new Object[0]);
    L18:
        r101.setSessionStatus(IExtendedSmModel.SessionStatus.UNLOADED);
        goto L4
    L8:
        if (r103 != 2) goto L10;
        int r104 = terminateSvaSession(r102);
        LogUtils.d(this.TAG, "releaseAllSvaSessions: started status returnCode = " + r104, new Object[0]);
        goto L18
    L10:
        if (r103 != 3) goto L12;
        int r105 = unloadSM(r102);
        LogUtils.d(this.TAG, "releaseAllSvaSessions: loaded status returnCode = " + r105, new Object[0]);
        goto L18
    L12:
        if (r103 == 4) goto L14;
        LogUtils.d(this.TAG, "releaseAllSvaSessions: invalid status value", new Object[0]);
        goto L18
    L14:
        int r106 = unloadSM(r102);
        LogUtils.d(this.TAG, "releaseAllSvaSessions: stopped status returnCode = " + r106, new Object[0]);
        goto L18
    L19:
        LogUtils.d(this.TAG, "releaseAllSvaSessions: detachModule is called", new Object[0]);
        detachModule(null);
    }

    private /* synthetic */ void lambda$new$0() {
        if (attachModule() == true) goto L6;
        LogUtils.e(this.TAG, "LegacyWakeupSession: attachModule failed", new Object[0]);
        return;
    }

    public LegacyWakeupSession(Context r100) {
        this.TAG = "LegacyWakeupSession[" + getSessionType() + "]";
        this.mAttachLock = new Object();
        this.mSTModule = null;
        this.mWakeupListeners = new CopyOnWriteArrayList();
        this.mVendorUuid = null;
        this.mVendorUuidFromHal = null;
        this.mKeyphraseFromXml = null;
        this.mOpaqueDataFromXml = null;
        this.mIsSupportConcurrency = false;
        this.mLastStage1UserConfig = "";
        this.mContext = r100;
        this.statusListenerWrapper = new AnonymousClass1(this);
        this.mExtendedSmMgr = Global.getInstance().getExtendedSmMgr();
        ThreadMethodProxy.start(new PthreadThreadV2(new b(this), "LegacyWakeupSession"));
    }

    private SoundTriggerWrapper.KeyphraseSoundModelWrapper createSTKeyphraseSoundModel(String r210) {
        if (r210 != null) goto L6;
        LogUtils.d(this.TAG, "createSTKeyphraseSoundModel: invalid input param", new Object[0]);
        return null;
    L6:
        SettingsModel r100 = new SettingsModel(this.mContext, r210);
        int r101 = 3;
        ByteBuffer r110 = c.e(this.mExtendedSmMgr.getSoundModelFullPath(r210));     // Catch: IOException -> L65
        IExtendedSmModel r111 = this.mExtendedSmMgr.getSoundModel(r210);
        if (r111 != null) goto L13;
        LogUtils.d(this.TAG, "createSTKeyphraseSoundModel: read getSoundModel data fail", new Object[0]);
        return null;
    L13:
        if (Global.getInstance().getIsToggleXmlParam() == false) goto L19;
        LogUtils.d(this.TAG, "createSTKeyphraseSoundModel: A", new Object[0]);
        createStkSmInfoFromXml(r210);
        if (this.mKeyphraseFromXml != null) goto L18;
        LogUtils.d(this.TAG, "createSTKeyphraseSoundModel: mKeyphraseFromXml is null", new Object[0]);
        return null;
    L18:
        SoundTriggerWrapper.KeyphraseWrapper[] r102 = {new SoundTriggerWrapper.KeyphraseWrapper(0, 3, Locale.forLanguageTag(DyResUtils.ResI18n.en_US), this.mKeyphraseFromXml, new int[0])};
        SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] r103 = {new SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper(0, 1, 69, new SoundTriggerWrapper.ConfidenceLevelWrapper[0])};
    L56:
        r111.setKeyphraseRecognitionExtra(r103);
        r110.rewind();
        byte[] r104 = new byte[r110.remaining()];
        r110.get(r104);
        String r105 = getModelUuid();
        if (r105 != null) goto L68;
        LogUtils.e(this.TAG, "createSTKeyphraseSoundModel: modelUuid is null", new Object[0]);
        return null;
    L68:
        this.mVendorUuid = UUID.fromString(r105);     // Catch: IllegalArgumentException -> L63
        return new SoundTriggerWrapper.KeyphraseSoundModelWrapper(r111.getSoundModelUUID(), this.mVendorUuid, r104, r102);
    L63:
        LogUtils.e(this.TAG, "createSTKeyphraseSoundModel: invalid UUID format: " + maskTailForLog(r105), new Object[0]);
        return null;
    L19:
        this.mVendorUuid = this.mVendorUuidFromHal;
        int r106 = r111.getSoundModelKeyphraseList().size();
        LogUtils.d(this.TAG, "createSTKeyphraseSoundModel: B size =" + r106, new Object[0]);
        SoundTriggerWrapper.KeyphraseWrapper[] r112 = new SoundTriggerWrapper.KeyphraseWrapper[r106];
        SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] r113 = new SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[r106];
        int r114 = 0;
    L20:
        if (r114 >= r106) goto L55;
        IKeyphraseModel r115 = (IKeyphraseModel) ListProtector.get(r111.getSoundModelKeyphraseList(), r114);
        int r107 = r115.getUserList().size();
        int[] r108 = new int[r107];
        Iterator<IUserModel> r109 = r115.getUserList().iterator();
        int r116 = 0;
    L23:
        if (r109.hasNext() == false) goto L25;
        r108[r116] = r109.next().getUserId();
        r116 = r116 + 1;
        goto L23
    L25:
        int r117 = r114;
        SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] r118 = r113;
        SoundTriggerWrapper.KeyphraseWrapper r119 = new SoundTriggerWrapper.KeyphraseWrapper(r115.getKeyphraseId(), r101, Locale.forLanguageTag(DyResUtils.ResI18n.en_US), r115.getKeyphraseFullName(), r108);
        r112[r117] = r119;
        SoundTriggerWrapper.ConfidenceLevelWrapper[] r120 = new SoundTriggerWrapper.ConfidenceLevelWrapper[r107];
        boolean r121 = r100.getOpaqueDataTransferEnabled();
        int r122 = 0;
    L26:
        int r123 = 100;
        if (r122 >= r107) goto L42;
        if (r111.isSupportExtendedOpaqueData() == false) goto L36;
        int r124 = r100.get2ndUserConfidenceLevel();
        if (r121 == false) goto L37;
        if (r124 >= 0) goto L34;
        r124 = 0;
        goto L37
    L34:
        if (r124 <= 100) goto L37;
        r124 = 100;
    L37:
        if (r124 < 0) goto L40;
        r123 = r124;
    L40:
        SoundTriggerWrapper.ConfidenceLevelWrapper r125 = new SoundTriggerWrapper.ConfidenceLevelWrapper(r119.getUsers()[r122], r123);
        r120[r122] = r125;
        LogUtils.d(this.TAG, "createSTKeyphraseSoundModel: level  " + r125, new Object[0]);
        r122 = r122 + 1;
        goto L26
    L36:
        r124 = r100.get1stUserConfidenceLevel();
        goto L37
    L42:
        if (r111.isSupportExtendedOpaqueData() == false) goto L49;
        int r126 = r100.get2ndKeyphraseConfidenceLevel();
        if (r121 == false) goto L50;
        if (r126 >= 0) goto L47;
        r126 = 0;
        goto L50
    L47:
        if (r126 <= 100) goto L50;
        r126 = 100;
    L50:
        LogUtils.d(this.TAG, "createSTKeyphraseSoundModel: keyphraseConfidenceLevel  " + r126, new Object[0]);
        if (r126 < 0) goto L54;
        r123 = r126;
    L54:
        SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper r127 = new SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper(r115.getKeyphraseId(), 3, r123, r120);
        LogUtils.d(this.TAG, "==== recognition extra " + r127, new Object[0]);
        r118[r117] = r127;
        r114 = r117 + 1;
        r113 = r118;
        r101 = 3;
        goto L20
    L49:
        r126 = r100.get1stKeyphraseConfidenceLevel();
        goto L50
    L55:
        r102 = r112;
        r103 = r113;
    L65:
        e = move-exception;
        LogUtils.e(this.TAG, "createSTKeyphraseSoundModel: read sound model failed, smName=" + r210 + ", err=" + e, new Object[0]);
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v44 */
    /* JADX WARN: Type inference failed for: r3v45 */
    /* JADX WARN: Type inference failed for: r3v46 */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r3v50 */
    private void createStkSmInfoFromXml(String r100) {
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: enter", new Object[0]);
        String r101 = Global.getInstance().PATH_ROOT + HTTP.URL_DEFAULT + r100 + ".xml";
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: smName= " + r100 + ", xmlFilePath= " + r101, new Object[0]);
        ?? r102 = 0;
        PolarisFileInputStreamWrapper r103 = null;
        PolarisFileInputStreamWrapper r104 = null;
        PolarisFileInputStreamWrapper r105 = null;
        PolarisFileInputStreamWrapper r106 = new PolarisFileInputStreamWrapper(new PolarisFileWrapper(r101));     // Catch: Throwable -> L50 IOException -> L52 XmlPullParserException -> L57 FileNotFoundException -> L61
    L82:
        XmlPullParser r107 = XmlPullParserFactory.newInstance().newPullParser();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        r107.setInput(r106, null);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        int r108 = r107.getEventType();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
    L6:
        if (r108 == 1) goto L37;
        if (r108 != 0) goto L9;
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: start_document parser.getName() = " + r107.getName(), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
    L36:
        int r109 = r107.next();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: parser.next() = " + r107.getName(), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        r108 = r109;
        goto L6
    L9:
        if (r108 != 2) goto L11;
        String r110 = r107.getName();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: start_tag = " + r110, new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        if (r110.equals("KeyphraseSoundModel") == true) goto L36;
        if (r110.equals("Uuid") == false) goto L21;
        r107.next();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: Uuid = " + maskTailForLog(r107.getText()), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        goto L36
    L21:
        if (r110.equals("VendorUuid") == false) goto L27;
        r107.next();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: VendorUuid = " + maskTailForLog(r107.getText()), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        this.mVendorUuid = UUID.fromString(r107.getText());     // Catch: IllegalArgumentException -> L25 Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
    L25:
        LogUtils.e(this.TAG, "createStkSmInfoFromXml: invalid VendorUuid format: " + maskTailForLog(r107.getText()), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        goto L36
    L27:
        if (r110.equals("Data") == false) goto L32;
        r107.next();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: Data= " + r107.getText(), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        if (r107.getText().equals("true") == false) goto L36;
        String r111 = Global.getInstance().PATH_ROOT + HTTP.URL_DEFAULT + r100 + Global.SUFFIX_DATA_FILE;     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: opaqueData  filepath = " + r111, new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        this.mOpaqueDataFromXml = c.d(r111);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        goto L36
    L32:
        if (r110.equals("Text") == false) goto L34;
        r107.next();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: Text = " + r107.getText(), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        this.mKeyphraseFromXml = r107.getText();     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        goto L36
    L34:
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: startTag = " + r110 + " not recognized.", new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        goto L36
    L11:
        if (r108 != 3) goto L36;
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: end_tag = " + r107.getName(), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        goto L36
    L37:
        if (r108 != 1) goto L39;
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: END_DOCUMENT", new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: END_DOCUMENT parser.getName()= " + r107.getName(), new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        ?? r112 = "createStkSmInfoFromXml: END_DOCUMENT parser.getName()= ";
    L40:
        r106.close();     // Catch: IOException -> L69
        r102 = r112;
    L71:
        return;
    L39:
        LogUtils.d(this.TAG, "createStkSmInfoFromXml: Could not reach end of document.", new Object[0]);     // Catch: Throwable -> L42 IOException -> L44 XmlPullParserException -> L46 FileNotFoundException -> L48
        r112 = r108;
    L48:
        e = e;
        r103 = r106;
    L62:
        e.printStackTrace();     // Catch: Throwable -> L50
        r102 = r103;
        PolarisFileInputStreamWrapper r113 = r103;
        if (r103 == null) goto L71;
    L55:
        r113.close();     // Catch: IOException -> L69
        r102 = r113;
    L44:
        e = e;
        r104 = r106;
    L53:
        e.printStackTrace();     // Catch: Throwable -> L50
        r102 = r104;
        r113 = r104;
        if (r104 == null) goto L71;
    L46:
        e = e;
        r105 = r106;
    L58:
        e.printStackTrace();     // Catch: Throwable -> L50
        r102 = r105;
        if (r105 == null) goto L71;
        r113 = r105;
    L42:
        th = th;
        r102 = r106;
    L66:
        if (r102 != 0) goto L76;
    L68:
        throw th;
    L76:
        r102.close();     // Catch: IOException -> L70
    L50:
        th = th;
    L61:
        e = e;
    L52:
        e = e;
    L57:
        e = e;
    }

    private void detachModule(String r100) {
        LogUtils.d(this.TAG, "detachModule: enter :" + r100, new Object[0]);
        Object r101 = this.mAttachLock;
        monitor-enter(r101);
        SoundTriggerModuleWrapper r102 = this.mSTModule;     // Catch: Throwable -> L17
        this.mSTModule = null;     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
        if (r102 == null) goto L12;
        LogUtils.d(this.TAG, "detachModule: mSTModule.detach() is called", new Object[0]);
        r102.detach();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        LogUtils.d(this.TAG, "detachModule: detach failed, possibly due to audio server death: " + e.getMessage(), new Object[0]);
    L12:
        if (r100 != null) goto L14;
        this.mExtendedSmMgr.resetAllSessionStatus();
    L15:
        LogUtils.d(this.TAG, "detachModule: exit " + r100, new Object[0]);
        return;
    L14:
        this.mExtendedSmMgr.resetSessionStatus(r100);
    L17:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$startRecognition$1(SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper r100) {
        LogUtils.d(this.TAG, "startRecognition: item = " + r100, new Object[0]);
    }

    private String maskTailForLog(String r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.isEmpty() == false) goto L7;
        return "";
    L7:
        return "****" + r100.substring(Math.max(0, r100.length() - 4));
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public void addWakeupListener(IWakeupListener r100) {
        if (this.mWakeupListeners.contains(r100) == false) goto L5;
        LogUtils.d(this.TAG, "addWakeupListener: listener already exists", new Object[0]);
        return;
    L5:
        LogUtils.d(this.TAG, "addWakeupListener: add listener " + r100, new Object[0]);
        this.mWakeupListeners.add(r100);
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public int establishSvaSession(String r100) {
        LogUtils.d(this.TAG, "establishSvaSession: smName = " + r100, new Object[0]);
        if (r100 != null) goto L6;
        LogUtils.d(this.TAG, "establishSvaSession: invalid input param", new Object[0]);
        return -1000;
    L6:
        int r101 = loadSM(r100);
        if (r101 == 0) goto L10;
        LogUtils.d(this.TAG, "establishSvaSession: loadSM returnCode = " + r101, new Object[0]);
        return r101;
    L10:
        int r102 = startRecognition(r100);
        if (r102 == 0) goto L13;
        LogUtils.d(this.TAG, "establishSvaSession: startRecognition returnCode = " + r102, new Object[0]);
        unloadSM(r100);
    L13:
        return r102;
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public boolean isRecognitionActive(String r100) {
        LogUtils.d(this.TAG, "isRecognitionActive: not support for legacy STModule API", new Object[0]);
        return false;
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public int loadSM(String r100) {
        String r101 = Build.MODEL;
        LogUtils.d(this.TAG, "loadSM: build model name = " + r101, new Object[0]);
        LogUtils.d(this.TAG, "loadSM: ## smName = " + r100, new Object[0]);
        if (r100 != null) goto L6;
        LogUtils.d(this.TAG, "loadSM: invalid input param", new Object[0]);
        return -1000;
    L6:
        String r102 = this.mExtendedSmMgr.getSoundModelFullPath(r100);
        IExtendedSmModel r103 = this.mExtendedSmMgr.getSoundModel(r100);
        if (r103 != null) goto L9;
    L37:
        LogUtils.d(this.TAG, "loadSM: sm file not exist", new Object[0]);
        return -1001;
    L9:
        if (c.c(r102) == false) goto L37;
        if (this.mSTModule != null) goto L17;
        LogUtils.d(this.TAG, "loadSM: mSTModule is null, need retry attachModule", new Object[0]);
        if (attachModule() == true) goto L17;
        LogUtils.e(this.TAG, "loadSM: retry attachModule fail", new Object[0]);
        return -1003;
    L17:
        IExtendedSmModel.SessionStatus r104 = IExtendedSmModel.SessionStatus.LOADED;
        if (r104 != r103.getSessionStatus()) goto L20;
    L35:
        LogUtils.d(this.TAG, "loadSM: already loaded, return success", new Object[0]);
        return 0;
    L20:
        if (IExtendedSmModel.SessionStatus.STOPPED == r103.getSessionStatus()) goto L35;
        SoundTriggerWrapper.KeyphraseSoundModelWrapper r105 = createSTKeyphraseSoundModel(r100);
        if (r105 != null) goto L26;
        LogUtils.d(this.TAG, "loadSM: create KeyphraseSoundModel fail", new Object[0]);
        return -1003;
    L26:
        int[] r106 = new int[20];
        SoundTriggerModuleWrapper r107 = this.mSTModule;
        if (r107 != null) goto L30;
        LogUtils.d(this.TAG, "loadSM: mSTModule is null", new Object[0]);
        return -1003;
    L30:
        LogUtils.d(this.TAG, "loadSM: start to loadSoundModel with " + r105, new Object[0]);
        int r108 = r107.loadSoundModel(r105, r106);
        if (r108 != 0) goto L33;
        LogUtils.d(this.TAG, "loadSM: STM loadSoundModel success", new Object[0]);
        r103.setSessionStatus(r104);
        r103.setSoundModelHandle(r106[0]);
    L34:
        return r108;
    L33:
        LogUtils.d(this.TAG, "loadSM: STM loadSoundModel failed !", new Object[0]);
        goto L34
    }

    public void onModelUnloadedWrapper(int r100) {
        LogUtils.d(this.TAG, "onModelUnloaded is recalled, do nothing. handle = " + r100, new Object[0]);
    }

    public void onRecognitionWrapper(SoundTriggerWrapper.RecognitionEventWrapper r100) {
        LogUtils.d(this.TAG, "onRecognition: recognitionEvent = " + r100, new Object[0]);
        Iterator<IWakeupListener> r101 = this.mWakeupListeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onRecognition(getSessionType(), r100);
        goto L4
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public void releaseSvaSession(String r100) {
        LogUtils.d(this.TAG, "@@ releaseSvaSession @@ :" + r100, new Object[0]);
        Iterator<IExtendedSmModel> r101 = this.mExtendedSmMgr.getAllSoundModelList().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        IExtendedSmModel r102 = r101.next();
        if (r102.getSoundModelFullFileName().equalsIgnoreCase(r100) == false) goto L4;
    L9:
        if (r102 != null) goto L11;
        return;
    L11:
        LogUtils.d(this.TAG, "releaseSvaSession: smName = " + r100, new Object[0]);
        int r103 = AnonymousClass2.$SwitchMap$com$obric$sva$sdk$data$IExtendedSmModel$SessionStatus[r102.getSessionStatus().ordinal()];
        if (r103 != 1) goto L14;
        LogUtils.d(this.TAG, "releaseSvaSession: unloaded status, do nothing", new Object[0]);
    L24:
        r102.setSessionStatus(IExtendedSmModel.SessionStatus.UNLOADED);
        LogUtils.d(this.TAG, "releaseSvaSession: detachModule is called", new Object[0]);
        detachModule(r100);
        return;
    L14:
        if (r103 != 2) goto L16;
        int r104 = terminateSvaSession(r100);
        LogUtils.d(this.TAG, "releaseSvaSession: started status returnCode = " + r104, new Object[0]);
        goto L24
    L16:
        if (r103 != 3) goto L18;
        int r105 = unloadSM(r100);
        LogUtils.d(this.TAG, "releaseSvaSession: loaded status returnCode = " + r105, new Object[0]);
        goto L24
    L18:
        if (r103 == 4) goto L20;
        LogUtils.d(this.TAG, "releaseSvaSession: invalid status value", new Object[0]);
        goto L24
    L20:
        int r106 = unloadSM(r100);
        LogUtils.d(this.TAG, "releaseSvaSession: stopped status returnCode = " + r106, new Object[0]);
        goto L24
    L8:
        r102 = null;
        goto L9
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public void removeWakeupListener(IWakeupListener r100) {
        if (this.mWakeupListeners.contains(r100) == false) goto L5;
        LogUtils.d(this.TAG, "removeWakeupListener: remove listener " + r100, new Object[0]);
        this.mWakeupListeners.remove(r100);
        return;
    L5:
        LogUtils.d(this.TAG, "removeWakeupListener: listener not exist, do nothing", new Object[0]);
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public int restartRecognition(String r100) {
        LogUtils.d(this.TAG, "restartRecognition: smName = " + r100, new Object[0]);
        if (r100 != null) goto L6;
        LogUtils.d(this.TAG, "restartRecognition: invalid input param", new Object[0]);
        return -1000;
    L6:
        IExtendedSmModel r101 = this.mExtendedSmMgr.getSoundModel(r100);
        if (r101 != null) goto L10;
        LogUtils.d(this.TAG, "restartRecognition: extendedSmModel is null", new Object[0]);
        return -1003;
    L10:
        IExtendedSmModel.SessionStatus r102 = IExtendedSmModel.SessionStatus.STARTED;
        if (r102 == r101.getSessionStatus()) goto L14;
        LogUtils.d(this.TAG, "restartRecognition: failure for wrong status", new Object[0]);
        return -1003;
    L14:
        SoundTriggerModuleWrapper r103 = this.mSTModule;
        if (r103 != null) goto L19;
        LogUtils.d(this.TAG, "restartRecognition: failure for mSTModule is null", new Object[0]);
        return -1003;
    L19:
        if (getSessionType() != SessionType.VOICE) goto L24;
        String r104 = rna.b.h(this.mContext);
        if (r104.hashCode() == this.mLastStage1UserConfig.hashCode()) goto L24;
        LogUtils.d(this.TAG, "restartRecognition: config has changed , so stop then start", new Object[0]);
        this.mLastStage1UserConfig = r104;
        stopRecognition(r100);
        int r105 = startRecognition(r100);
        LogUtils.d(this.TAG, "restartRecognition: config has changed , start with code :" + r105, new Object[0]);
        return r105;
    L24:
        int r106 = r103.startRecognition(r101.getSoundModelHandle(), r101.getRecognitionConfig());
        if (r106 != 0) goto L27;
        LogUtils.d(this.TAG, "restartRecognition: STM restartRecognition success", new Object[0]);
        r101.setSessionStatus(r102);
    L27:
        return r106;
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public int startRecognition(String r210) {
        LogUtils.d(this.TAG, "startRecognition: smName = " + r210, new Object[0]);
        if (r210 != null) goto L6;
        LogUtils.d(this.TAG, "startRecognition: invalid input param", new Object[0]);
        return -1000;
    L6:
        ExtendedSmMgr r100 = this.mExtendedSmMgr;
        if (r100 != null) goto L10;
        LogUtils.d(this.TAG, "startRecognition: invalid extended Sm Mgr", new Object[0]);
        return -1004;
    L10:
        IExtendedSmModel r101 = r100.getSoundModel(r210);
        if (r101 != null) goto L14;
        LogUtils.d(this.TAG, "startRecognition: extendedSmModel is null", new Object[0]);
        return -1003;
    L14:
        IExtendedSmModel.SessionStatus r110 = IExtendedSmModel.SessionStatus.STARTED;
        if (r110 != r101.getSessionStatus()) goto L19;
        LogUtils.d(this.TAG, "startRecognition: already started, return success directly", new Object[0]);
        return 0;
    L19:
        if (isStateTransitional(r101.getSessionStatus(), r110) == true) goto L22;
        LogUtils.d(this.TAG, "startRecognition: failure for wrong status", new Object[0]);
        return -1003;
    L22:
        SoundTriggerWrapper.KeyphraseRecognitionExtraWrapper[] r111 = r101.getKeyphraseRecognitionExtra();
        if (r111 != null) goto L27;
        LogUtils.d(this.TAG, "startRecognition: failure for stKpRecognitionExtraArray", new Object[0]);
        return -1003;
    L27:
        if (Build.VERSION.SDK_INT < 24) goto L29;
        Arrays.stream(r111).forEach(new a(this));
    L29:
        SettingsModel r112 = new SettingsModel(this.mContext, r210);
        boolean r113 = r112.getVoiceRequestEnabled();
        boolean r102 = r112.getOpaqueDataTransferEnabled();
        int r114 = r112.getHistBufferTime();
        int r115 = r112.getPreRollDuration();
        if (r102 == true) goto L32;
        byte[] r103 = null;
    L47:
        SoundTriggerWrapper.RecognitionConfigWrapper r104 = new SoundTriggerWrapper.RecognitionConfigWrapper(r113, true, r111, r103);
        r101.setRecognitionConfig(r104);
        LogUtils.d(this.TAG, "startRecognition: STM startRecognition now !! with mSTModule : " + this.mSTModule, new Object[0]);
        SoundTriggerModuleWrapper r105 = this.mSTModule;
        if (r105 != null) goto L51;
        LogUtils.d(this.TAG, "startRecognition: failure for mStModule is null", new Object[0]);
        return -1003;
    L51:
        int r106 = r105.startRecognition(r101.getSoundModelHandle(), r104);
        if (r106 != 0) goto L54;
        LogUtils.d(this.TAG, "startRecognition: STM startRecognition success", new Object[0]);
        r101.setSessionStatus(r110);
    L54:
        return r106;
    L32:
        if (r101.isSupportExtendedOpaqueData() == false) goto L42;
        SessionType r107 = getSessionType();
        SessionType r108 = SessionType.VOICE;
        if (r107 != r108) goto L36;
        boolean r116 = true;
    L37:
        OpaqueDataHelper r109 = new OpaqueDataHelper(r210, r102, false, false, r116);
        int r117 = r112.get2ndKeyphraseConfidenceLevel();
        int r118 = r112.get2ndUserConfidenceLevel();
        int r119 = r112.get1stKeyphraseConfidenceLevel();
        int r120 = r112.get1stUserConfidenceLevel();
        Stage1Config r121 = new Stage1Config();
        if (getSessionType() != r108) goto L40;
        this.mLastStage1UserConfig = r121.acquireUserConfig(this.mContext);
        OpaqueDataHelper r122 = r109;
        r122.mNumberOfStage1Config = Math.max(r121.size(), 0);
        LogUtils.d(this.TAG, "startRecognition A: stage1Config " + r121 + " stage1Size: " + r122.mNumberOfStage1Config, new Object[0]);
    L41:
        r103 = r122.fillOpaqueDataByteBuffer(r119, r120, r117, r118, r114, r115, 0, 0, r121);
    L44:
        if (Global.getInstance().getIsToggleXmlParam() == false) goto L47;
        r103 = this.mOpaqueDataFromXml;
        goto L47
    L40:
        r122 = r109;
        r122.mNumberOfStage1Config = 0;
        LogUtils.d(this.TAG, "startRecognition B: 0 Stage1Config", new Object[0]);
        goto L41
    L36:
        r116 = false;
        goto L37
    L42:
        r103 = new OpaqueDataHelper(r210, false, false, false, false).fillOpaqueDataByteBuffer(r114, r115);
        goto L44
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public int stopRecognition(String r100) {
        LogUtils.d(this.TAG, "stopRecognition: smName = " + r100, new Object[0]);
        if (r100 != null) goto L6;
        LogUtils.d(this.TAG, "stopRecognition: invalid input param", new Object[0]);
        return -1000;
    L6:
        IExtendedSmModel r101 = this.mExtendedSmMgr.getSoundModel(r100);
        if (r101 != null) goto L10;
        LogUtils.d(this.TAG, "stopRecognition: extendedSmModel is null", new Object[0]);
        return -1003;
    L10:
        IExtendedSmModel.SessionStatus r102 = IExtendedSmModel.SessionStatus.STOPPED;
        if (r102 != r101.getSessionStatus()) goto L13;
    L27:
        LogUtils.d(this.TAG, "stopRecognition: already stopped, return success directly", new Object[0]);
        return 0;
    L13:
        if (IExtendedSmModel.SessionStatus.LOADED == r101.getSessionStatus()) goto L27;
        if (isStateTransitional(r101.getSessionStatus(), r102) == true) goto L19;
        LogUtils.d(this.TAG, "stopRecognition: failure for wrong status", new Object[0]);
        return -1002;
    L19:
        SoundTriggerModuleWrapper r103 = this.mSTModule;
        if (r103 != null) goto L23;
        LogUtils.d(this.TAG, "stopRecognition: mSTModule is null !", new Object[0]);
        return -1003;
    L23:
        int r104 = r103.stopRecognition(r101.getSoundModelHandle());
        if (r104 != 0) goto L26;
        LogUtils.d(this.TAG, "stopRecognition: STM stopRecognition success", new Object[0]);
        r101.setSessionStatus(r102);
    L26:
        return r104;
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public int terminateSvaSession(String r100) {
        LogUtils.d(this.TAG, "terminateSvaSession: smName = " + r100, new Object[0]);
        if (r100 != null) goto L6;
        LogUtils.d(this.TAG, "terminateSvaSession: invalid input param", new Object[0]);
        return -1000;
    L6:
        int r101 = stopRecognition(r100);
        IExtendedSmModel r102 = this.mExtendedSmMgr.getSoundModel(r100);
        if (r102 == null) goto L9;
        r102.setSessionStatus(IExtendedSmModel.SessionStatus.STOPPED);
    L9:
        if (r101 == 0) goto L11;
        LogUtils.d(this.TAG, "terminateSvaSession: stopRecognition returnCode = " + r101, new Object[0]);
    L11:
        int r103 = unloadSM(r100);
        if (r103 == 0) goto L14;
        LogUtils.d(this.TAG, "terminateSvaSession: unloadSM returnCode = " + r103, new Object[0]);
    L14:
        return r103;
    }

    @Override // com.obric.sva.sdk.session.IWakeupSession
    public int unloadSM(String r100) {
        LogUtils.d(this.TAG, "unloadSM: smName = " + r100, new Object[0]);
        if (r100 != null) goto L6;
        LogUtils.d(this.TAG, "unloadSM: invalid input param", new Object[0]);
        return -1000;
    L6:
        IExtendedSmModel r101 = this.mExtendedSmMgr.getSoundModel(r100);
        if (r101 != null) goto L10;
        LogUtils.d(this.TAG, "unloadSM: extendedSmModel is null", new Object[0]);
        return -1003;
    L10:
        IExtendedSmModel.SessionStatus r102 = IExtendedSmModel.SessionStatus.UNLOADED;
        if (r102 != r101.getSessionStatus()) goto L15;
        LogUtils.d(this.TAG, "unloadSM: already unloaded, return success directly", new Object[0]);
        return 0;
    L15:
        if (isStateTransitional(r101.getSessionStatus(), r102) == true) goto L18;
        LogUtils.d(this.TAG, "unloadSM: failure for wrong status", new Object[0]);
        return -1003;
    L18:
        SoundTriggerModuleWrapper r103 = this.mSTModule;
        if (r103 != null) goto L22;
        LogUtils.d(this.TAG, "unloadSM: failure for null=mSTModule", new Object[0]);
        return -1003;
    L22:
        int r104 = r103.unloadSoundModel(r101.getSoundModelHandle());
        if (r104 != 0) goto L25;
        LogUtils.d(this.TAG, "unloadSM: STM unloadSoundModel success", new Object[0]);
        r101.setSessionStatus(r102);
    L25:
        return r104;
    }

    private boolean isStateTransitional(IExtendedSmModel.SessionStatus r100, IExtendedSmModel.SessionStatus r101) {
        int r102 = AnonymousClass2.$SwitchMap$com$obric$sva$sdk$data$IExtendedSmModel$SessionStatus[r101.ordinal()];
        if (r102 == 1) goto L18;
        if (r102 == 2) goto L18;
        if (r102 == 3) goto L15;
        if (r102 == 4) goto L12;
        LogUtils.e("isStateTransitional: unrecognized state" + r101, new Object[0]);
    L22:
        return false;
    L12:
        if (IExtendedSmModel.SessionStatus.STARTED != r100) goto L22;
        return true;
    L15:
        if (IExtendedSmModel.SessionStatus.UNLOADED != r100) goto L22;
        return true;
    L18:
        if (IExtendedSmModel.SessionStatus.LOADED != r100) goto L20;
    L23:
        return true;
    L20:
        if (IExtendedSmModel.SessionStatus.STOPPED != r100) goto L22;
        goto L22
    }
}
