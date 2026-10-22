package com.bytedance.lark.office_sdk_im_android;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import office_sdk_im.proto.FuncReturnX3dc8b8542df1cbb1;
import office_sdk_im.proto.MoltenContextExtra;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\bH\u0096\u0001J\t\u0010\t\u001a\u00020\bH\u0096\u0001J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lark/office_sdk_im_android/OfficeSdkHostSettingProxy;", "Lcom/bytedance/lark/office_sdk_im_android/OfficeSdkHostSetting;", "Lcom/bytedance/lark/office_sdk_im_android/MoltenFFICallback;", "callbackObj", "(Lcom/bytedance/lark/office_sdk_im_android/OfficeSdkHostSetting;)V", "getCallbackObj", "()Lcom/bytedance/lark/office_sdk_im_android/OfficeSdkHostSetting;", "getIsImFeatureOpenedByHostManual", "", "getIsLegacyPcSidePanelImFeatureOpened", "invokeGetIsImFeatureOpenedByHostManualX46a98d35", "", "params", "invokeGetIsLegacyPcSidePanelImFeatureOpenedX46a98d35", "onInvoke", "methodId", "", "Companion", "office_sdk_im_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class OfficeSdkHostSettingProxy implements OfficeSdkHostSetting, MoltenFFICallback {
    public static final Companion Companion = null;
    private final OfficeSdkHostSetting callbackObj;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/office_sdk_im_android/OfficeSdkHostSettingProxy$Companion;", "", "()V", "obtain", "", "callback", "Lcom/bytedance/lark/office_sdk_im_android/OfficeSdkHostSetting;", "office_sdk_im_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final long obtain(OfficeSdkHostSetting r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            OfficeSdkHostSettingProxy r101 = new OfficeSdkHostSettingProxy(r100, null);
            return CallbackInstance.INSTANCE.registerInstance(r101);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ OfficeSdkHostSettingProxy(OfficeSdkHostSetting r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    @Override // com.bytedance.lark.office_sdk_im_android.OfficeSdkHostSetting
    public boolean getIsImFeatureOpenedByHostManual() {
        return this.callbackObj.getIsImFeatureOpenedByHostManual();
    }

    @Override // com.bytedance.lark.office_sdk_im_android.OfficeSdkHostSetting
    public boolean getIsLegacyPcSidePanelImFeatureOpened() {
        return this.callbackObj.getIsLegacyPcSidePanelImFeatureOpened();
    }

    @Override // com.bytedance.lark.office_sdk_im_android.MoltenFFICallback
    public /* bridge */ /* synthetic */ Object getCallbackObj() {
        return getCallbackObj();
    }

    @Override // com.bytedance.lark.office_sdk_im_android.MoltenFFICallback
    public OfficeSdkHostSetting getCallbackObj() {
        return this.callbackObj;
    }

    private OfficeSdkHostSettingProxy(OfficeSdkHostSetting r100) {
        this.callbackObj = r100;
    }

    private final byte[] invokeGetIsImFeatureOpenedByHostManualX46a98d35(byte[] r100) {
        MoltenContextExtra r101 = MoltenContextExtra.ADAPTER.decode(r100);
        Intrinsics.checkNotNull(r101);
        MoltenFfiLibOfficeSdkIm.Companion r102 = MoltenFfiLibOfficeSdkIm.Companion;
        Object r103 = r102.onInvokeeStart(r101._molten_ctx);
        FuncReturnX3dc8b8542df1cbb1 r104 = new FuncReturnX3dc8b8542df1cbb1(Boolean.valueOf(getIsImFeatureOpenedByHostManual()), null);     // Catch: Throwable -> L6 Exception -> L8
        Pair r105 = new Pair(0L, FuncReturnX3dc8b8542df1cbb1.ADAPTER.encode(r104));     // Catch: Throwable -> L6 Exception -> L8
        r102.onInvokeeEnd(r103);
        return (byte[]) r105.getSecond();
    L8:
        e = move-exception;
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        MoltenFfiLibOfficeSdkIm.Companion.onInvokeeEnd(r103);
        throw th;
    }

    private final byte[] invokeGetIsLegacyPcSidePanelImFeatureOpenedX46a98d35(byte[] r100) {
        MoltenContextExtra r101 = MoltenContextExtra.ADAPTER.decode(r100);
        Intrinsics.checkNotNull(r101);
        MoltenFfiLibOfficeSdkIm.Companion r102 = MoltenFfiLibOfficeSdkIm.Companion;
        Object r103 = r102.onInvokeeStart(r101._molten_ctx);
        FuncReturnX3dc8b8542df1cbb1 r104 = new FuncReturnX3dc8b8542df1cbb1(Boolean.valueOf(getIsLegacyPcSidePanelImFeatureOpened()), null);     // Catch: Throwable -> L6 Exception -> L8
        Pair r105 = new Pair(0L, FuncReturnX3dc8b8542df1cbb1.ADAPTER.encode(r104));     // Catch: Throwable -> L6 Exception -> L8
        r102.onInvokeeEnd(r103);
        return (byte[]) r105.getSecond();
    L8:
        e = move-exception;
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        MoltenFfiLibOfficeSdkIm.Companion.onInvokeeEnd(r103);
        throw th;
    }

    @Override // com.bytedance.lark.office_sdk_im_android.MoltenFFICallback
    public byte[] onInvoke(long r100, byte[] r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        if (r100 != 4373175834147130677L) goto L6;
        return invokeGetIsImFeatureOpenedByHostManualX46a98d35(r101);
    L6:
        if (r100 == (-2204406952922346187L)) goto L8;
        MethodId.m8433methodKeyimpl(MethodId.m8429constructorimpl(r100));
        throw new Exception("onInvoke $[methodId] $[desc]");
    L8:
        return invokeGetIsLegacyPcSidePanelImFeatureOpenedX46a98d35(r101);
    }

    @Override // com.bytedance.lark.office_sdk_im_android.MoltenFFICallback
    public void onInvokeAsync(long r100, long r101, byte[] r102) {
        MoltenFFICallback.DefaultImpls.onInvokeAsync(this, r100, r101, r102);
    }
}
