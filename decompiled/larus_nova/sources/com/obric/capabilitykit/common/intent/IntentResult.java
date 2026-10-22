package com.obric.capabilitykit.common.intent;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.gson.Gson;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.capabilitykit.common.CardView;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.RemoteCard;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 S*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001SB\u0081\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\b\u0010G\u001a\u00020\u0004H\u0016J/\u0010H\u001a\u00020I2\b\u0010\u0005\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020\tH\u0016J\u0018\u0010O\u001a\u00020I2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0004H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\u0014\u00102\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010)R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010)\"\u0004\b4\u0010+R \u00105\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010<\"\u0004\b@\u0010>R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006T"}, d2 = {"Lcom/obric/capabilitykit/common/intent/IntentResult;", ExifInterface.LONGITUDE_EAST, "Landroid/os/Parcelable;", "ret", "", "entity", "view", "Lcom/obric/capabilitykit/common/CardView;", "details", "", "inquireFurther", "", "needToSummarize", "uiType", "intent", "Landroid/content/Intent;", "floatingIntentParams", "Lcom/obric/capabilitykit/common/FloatingIntentParams;", "ext", "Ljava/util/concurrent/ConcurrentHashMap;", "(ILjava/lang/Object;Lcom/obric/capabilitykit/common/CardView;Ljava/lang/String;ZZILandroid/content/Intent;Lcom/obric/capabilitykit/common/FloatingIntentParams;Ljava/util/concurrent/ConcurrentHashMap;)V", "getDetails", "()Ljava/lang/String;", "setDetails", "(Ljava/lang/String;)V", "value", "getEntity", "()Ljava/lang/Object;", "setEntity", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "entityWrittenToFallbackOnly", "getExt", "()Ljava/util/concurrent/ConcurrentHashMap;", "setExt", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getFloatingIntentParams", "()Lcom/obric/capabilitykit/common/FloatingIntentParams;", "setFloatingIntentParams", "(Lcom/obric/capabilitykit/common/FloatingIntentParams;)V", "getInquireFurther", "()Z", "setInquireFurther", "(Z)V", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", DecodeProducer.EXTRA_IS_FINAL, "setFinal", "isParcelableArray", "getNeedToSummarize", "setNeedToSummarize", "remoteCard", "Lcom/obric/capabilitykit/common/RemoteCard;", "getRemoteCard", "()Lcom/obric/capabilitykit/common/RemoteCard;", "setRemoteCard", "(Lcom/obric/capabilitykit/common/RemoteCard;)V", "getRet", "()I", "setRet", "(I)V", "getUiType", "setUiType", "getView$annotations", "()V", "getView", "()Lcom/obric/capabilitykit/common/CardView;", "setView", "(Lcom/obric/capabilitykit/common/CardView;)V", "describeContents", "putEntityFallback", "", "", "elementClassName", "array", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Boolean;)V", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IntentResult<E> implements Parcelable {
    public static final b CREATOR = null;
    private static final int FLAG_INQUIRE_FURTHER = 1;
    private static final int FLAG_NEED_TO_SUMMARIZE = 2;
    public static final String KEY_ENTITY_FALLBACK_JSON = "__entity_fallback_json_v1__";
    public static final String KEY_ENTITY_FALLBACK_TYPE = "__entity_fallback_type_v1__";
    private static final int PARCELABLE = 0;
    private static final int PARCELABLE_ARRAY = 1;
    private static final String TAG = "IntentResult";
    private static final Lazy<Gson> sGson$delegate = null;
    private String details;
    private E entity;
    private transient boolean entityWrittenToFallbackOnly;
    private ConcurrentHashMap<String, String> ext;
    private FloatingIntentParams floatingIntentParams;
    private boolean inquireFurther;
    private Intent intent;
    public boolean isFinal;
    private boolean needToSummarize;
    public RemoteCard remoteCard;
    private int ret;
    private int uiType;
    private CardView view;

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lcom/google/gson/Gson;", AbsMethodDelegate.TAG_INVOKE, "()Lcom/google/gson/Gson;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class a extends Lambda implements Function0<Gson> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f396192a = null;

        static {
            f396192a = new a();
        }

        public a() {
            super(0);
        }

        public final Gson a() {
            return new Gson();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Gson invoke() {
            return a();
        }
    }

    public static final class b implements Parcelable.Creator<IntentResult<?>> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ IntentResult<?> createFromParcel(Parcel r100) {
            return b(r100);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v26 */
        /* JADX WARN: Type inference failed for: r5v0, types: [android.os.Parcelable] */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v10, types: [android.os.Parcelable[]] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v8, types: [java.lang.Object] */
        public static IntentResult b(Parcel r110) {
            int r100 = r110.readInt();
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r101 = r110.readInt();
            if (r110.readInt() != 1) goto L7;
            int r102 = r110.readInt();
            ?? r103 = new Parcelable[r102];
            int r104 = 0;
        L5:
            if (r104 >= r102) goto L8;
            r103[r104] = r110.readParcelable(IntentResult.class.getClassLoader());
            r104 = r104 + 1;
        L8:
            CardView r105 = (CardView) r110.readParcelable(CardView.class.getClassLoader());
            String r106 = r110.readString();
            Intent r111 = (Intent) r110.readParcelable(Intent.class.getClassLoader());
            FloatingIntentParams r112 = (FloatingIntentParams) r110.readParcelable(FloatingIntentParams.class.getClassLoader());
            int r107 = r110.readInt();
            if ((r107 & 1) == 0) goto L11;
            boolean r108 = true;
        L13:
            if ((r107 & 2) == 0) goto L15;
            boolean r109 = true;
        L16:
            int r113 = r110.readInt();
            Serializable r114 = r110.readSerializable();
            Object r115 = null;
            if ((r114 instanceof ConcurrentHashMap) == false) goto L19;
            ConcurrentHashMap r116 = (ConcurrentHashMap) r114;
        L20:
            if (r103 == 0) goto L30;
            if ((r103 instanceof Object[]) == true) goto L24;
        L66:
            IntentResult r117 = new IntentResult(r101, r103, r105, r106, r108, r109, r113, r111, r112, r116);
            int r118 = Math.min(r100, 2);
            ClassLoader r119 = b.class.getClassLoader();
            int r120 = 1;
        L67:
            if (r120 > r118) goto L79;
            if (r120 != 1) goto L73;
            Object r121 = joa.a.c(r110, r119);
            if (r121 == null) goto L77;
            r117.isFinal = ((Boolean) r121).booleanValue();
        L77:
            r120 = r120 + 1;
            goto L67
        L73:
            if (r120 != 2) goto L77;
            Object r122 = joa.a.c(r110, r119);
            if (r122 == null) goto L77;
            r117.remoteCard = (RemoteCard) r122;
        L79:
            if (r120 > r100) goto L81;
            joa.a.d(r110, r119);
            r120 = r120 + 1;
            goto L79
        L81:
            return r117;
        L24:
            if (((Object[]) r103).length != 0) goto L26;
            boolean r123 = true;
        L27:
            if (r123 == true) goto L30;
        L26:
            r123 = false;
        L30:
            if (r116 == null) goto L65;
            String r124 = (String) r116.get(IntentResult.KEY_ENTITY_FALLBACK_JSON);
            if (r124 == null) goto L65;
            if (r124.length() <= 0) goto L37;
            boolean r125 = true;
        L38:
            if (r125 == true) goto L41;
            r124 = null;
        L41:
            if (r124 == null) goto L65;
            String r126 = (String) r116.get(IntentResult.KEY_ENTITY_FALLBACK_TYPE);
            if (r126 == null) goto L65;
            if (r126.length() <= 0) goto L48;
            boolean r127 = true;
        L49:
            if (r127 == true) goto L52;
            r126 = null;
        L52:
            if (r126 == null) goto L65;
            boolean r128 = StringsKt.endsWith$default(r126, "[]", false, 2, null);     // Catch: Throwable -> L63
            if (r128 == false) goto L58;
            r126 = StringsKt.removeSuffix(r126, "[]");     // Catch: Throwable -> L63
        L58:
            Class r129 = a(r126);     // Catch: Throwable -> L63
            if (r128 == false) goto L61;
            Object r130 = ((Gson) IntentResult.access$getSGson$delegate$cp().getValue()).fromJson(r124, Array.newInstance(r129, 0).getClass());     // Catch: Throwable -> L63
        L62:
            r115 = r130;
            goto L65
        L61:
            r130 = ((Gson) IntentResult.access$getSGson$delegate$cp().getValue()).fromJson(r124, r129);     // Catch: Throwable -> L63
        L63:
            th = move-exception;
            th.getMessage();
            goto L65
        L48:
            r127 = false;
            goto L49
        L37:
            r125 = false;
        L65:
            r103 = r115;
            goto L66
        L19:
            r116 = null;
            goto L20
        L15:
            r109 = false;
            goto L16
        L11:
            r108 = false;
            goto L13
        L7:
            r103 = r110.readParcelable(IntentResult.class.getClassLoader());
            goto L8
        }

        @Override // android.os.Parcelable.Creator
        public final IntentResult<?>[] newArray(int r100) {
            return new IntentResult[r100];
        }
    }

    public IntentResult() {
        this(0, null, null, null, false, false, 0, null, null, null, 1023, null);
    }

    public IntentResult(int r100, E r101, CardView r102, String r103, boolean r104, boolean r105, int r106, Intent r107, FloatingIntentParams r108, ConcurrentHashMap<String, String> r110) {
        this.ret = r100;
        this.view = r102;
        this.details = r103;
        this.inquireFurther = r104;
        this.needToSummarize = r105;
        this.uiType = r106;
        this.intent = r107;
        this.floatingIntentParams = r108;
        this.ext = r110;
        this.isFinal = true;
        setEntity(r101);
    }

    public /* synthetic */ IntentResult(int r110, Object r111, CardView r112, String r113, boolean r114, boolean r115, int r116, Intent r117, FloatingIntentParams r210, ConcurrentHashMap r211, int r212, DefaultConstructorMarker r213) {
        int r100 = 1;
        if ((r212 & 1) == 0) goto L5;
        int r101 = 1;
    L6:
        ConcurrentHashMap r102 = null;
        if ((r212 & 2) == 0) goto L9;
        Object r103 = null;
    L11:
        if ((r212 & 4) == 0) goto L13;
        CardView r104 = null;
    L15:
        if ((r212 & 8) == 0) goto L17;
        String r105 = null;
    L18:
        boolean r106 = false;
        if ((r212 & 16) == 0) goto L21;
        boolean r107 = false;
    L23:
        if ((r212 & 32) != 0) goto L27;
        r106 = r115;
    L27:
        if ((r212 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r212 & 128) == 0) goto L33;
        Intent r108 = null;
    L35:
        if ((r212 & 256) == 0) goto L37;
        FloatingIntentParams r118 = null;
    L39:
        if ((r212 & 512) != 0) goto L42;
        r102 = r211;
    L42:
        this(r101, r103, r104, r105, r107, r106, r100, r108, r118, r102);
        return;
    L37:
        r118 = r210;
        goto L39
    L33:
        r108 = r117;
        goto L35
    L21:
        r107 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L18
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }

    public static final /* synthetic */ Lazy access$getSGson$delegate$cp() {
        return sGson$delegate;
    }

    @Deprecated(message = "use [RemoteCard] instead")
    public static /* synthetic */ void getView$annotations() {
    }

    private final boolean isParcelableArray() {
        return this.entity instanceof Object[];
    }

    public static /* synthetic */ void putEntityFallback$default(IntentResult r100, Object r101, String r102, Boolean r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r103 = null;
    L8:
        r100.putEntityFallback(r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getDetails() {
        return this.details;
    }

    public final E getEntity() {
        return this.entity;
    }

    public final ConcurrentHashMap<String, String> getExt() {
        return this.ext;
    }

    public final FloatingIntentParams getFloatingIntentParams() {
        return this.floatingIntentParams;
    }

    public final boolean getInquireFurther() {
        return this.inquireFurther;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final boolean getNeedToSummarize() {
        return this.needToSummarize;
    }

    public final RemoteCard getRemoteCard() {
        return this.remoteCard;
    }

    public final int getRet() {
        return this.ret;
    }

    public final int getUiType() {
        return this.uiType;
    }

    public final CardView getView() {
        return this.view;
    }

    public final boolean isFinal() {
        return this.isFinal;
    }

    public final void putEntityFallback(Object r100) {
        putEntityFallback$default(this, r100, null, null, 6, null);
    }

    public final void putEntityFallback(Object r100, String r101) {
        putEntityFallback$default(this, r100, r101, null, 4, null);
    }

    public final void setDetails(String r100) {
        this.details = r100;
    }

    public final void setEntity(E r100) {
        if (r100 != null) goto L4;
    L10:
        this.entity = r100;
        return;
    L4:
        if ((r100 instanceof Parcelable) == true) goto L10;
        if ((r100 instanceof Serializable) == true) goto L10;
        throw new RuntimeException("entity must be Parcelable or Serializable");
    }

    public final void setExt(ConcurrentHashMap<String, String> r100) {
        this.ext = r100;
    }

    public final void setFinal(boolean r100) {
        this.isFinal = r100;
    }

    public final void setFloatingIntentParams(FloatingIntentParams r100) {
        this.floatingIntentParams = r100;
    }

    public final void setInquireFurther(boolean r100) {
        this.inquireFurther = r100;
    }

    public final void setIntent(Intent r100) {
        this.intent = r100;
    }

    public final void setNeedToSummarize(boolean r100) {
        this.needToSummarize = r100;
    }

    public final void setRemoteCard(RemoteCard r100) {
        this.remoteCard = r100;
    }

    public final void setRet(int r100) {
        this.ret = r100;
    }

    public final void setUiType(int r100) {
        this.uiType = r100;
    }

    public final void setView(CardView r100) {
        this.view = r100;
    }

    public String toString() {
        return "IntentResult(ret=" + this.ret + ", view=" + this.view + ", details=" + this.details + ", uiType=" + this.uiType + ", ext=" + this.ext + ", inquireFurther=" + this.inquireFurther + ", needToSummarize=" + this.needToSummarize + ", entity=" + this.entity + ", intent=" + this.intent + ", floatingIntentParams=" + this.floatingIntentParams + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(2);
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.ret);
        Parcelable r102 = null;
        Parcelable[] r103 = null;
        if (this.entityWrittenToFallbackOnly == false) goto L5;
        E r104 = null;
    L6:
        int r105 = 0;
        if ((r104 instanceof Object[]) == true) goto L9;
        r100.writeInt(0);
        if ((r104 instanceof Parcelable) == false) goto L23;
        r102 = (Parcelable) r104;
    L23:
        r100.writeParcelable(r102, r101);
    L24:
        r100.writeParcelable(this.view, r101);
        r100.writeString(this.details);
        r100.writeParcelable(this.intent, r101);
        r100.writeParcelable(this.floatingIntentParams, r101);
        boolean r106 = this.inquireFurther;
        int r107 = r106;
        if (this.needToSummarize == false) goto L27;
        r107 = (r106 ? 1 : 0) | 2;
    L27:
        r100.writeInt(r107);
        r100.writeInt(this.uiType);
        r100.writeSerializable(this.ext);
        r100.writeValue(Boolean.valueOf(this.isFinal));
        r100.writeValue(this.remoteCard);
        return;
    L9:
        if ((r104 instanceof Parcelable[]) == false) goto L11;
        r103 = (Parcelable[]) r104;
    L11:
        r100.writeInt(1);
        if (r103 == null) goto L14;
        int r108 = r103.length;
    L15:
        r100.writeInt(r108);
        if (r103 == null) goto L24;
        int r109 = r103.length;
    L18:
        if (r105 >= r109) goto L24;
        r100.writeParcelable(r103[r105], r101);
        r105 = r105 + 1;
        goto L18
    L14:
        r108 = 0;
        goto L15
    L5:
        r104 = this.entity;
        goto L6
    }

    static {
        CREATOR = new b();
        sGson$delegate = LazyKt.lazy(a.f396192a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void putEntityFallback(Object r110, String r111, Boolean r112) {
        if (r110 != null) goto L5;
        Object r100 = null;
    L6:
        setEntity(r100);
        if (r110 != null) goto L15;
        this.entityWrittenToFallbackOnly = false;
        ConcurrentHashMap<String, String> r113 = this.ext;
        if (r113 == null) goto L11;
        String r114 = r113.remove(KEY_ENTITY_FALLBACK_JSON);
    L11:
        ConcurrentHashMap<String, String> r115 = this.ext;
        if (r115 == null) goto L60;
        String r116 = r115.remove(KEY_ENTITY_FALLBACK_TYPE);
        return;
    L60:
        return;
    L15:
        if (r112 == null) goto L17;
        boolean r117 = r112.booleanValue();
    L19:
        if (r111 != null) goto L45;
        if (r117 == true) goto L22;
    L43:
        Class<?> r118 = r110.getClass();
    L44:
        r111 = r118.getName();
        goto L45
    L22:
        if ((r110 instanceof Object[]) == false) goto L24;
        Object[] r119 = (Object[]) r110;
    L25:
        if (r119 == null) goto L38;
        int r101 = r119.length;
        int r102 = 0;
    L27:
        if (r102 >= r101) goto L35;
        Object r103 = r119[r102];
        if (r103 == null) goto L31;
        boolean r104 = true;
    L32:
        if (r104 == true) goto L36;
        r102 = r102 + 1;
    L36:
        if (r103 == null) goto L38;
        r118 = r103.getClass();
        goto L44
    L31:
        r104 = false;
        goto L32
    L35:
        r103 = null;
    L38:
        Class<?> r120 = r110.getClass().getComponentType();
        if (r120 == null) goto L41;
        r111 = r120.getName();
    L42:
        if (r111 != null) goto L45;
    L41:
        r111 = null;
        goto L42
    L24:
        r119 = null;
    L45:
        if (r117 == false) goto L56;
        r111 = r111.concat("[]");
    L56:
        CREATOR.getClass();     // Catch: Throwable -> L53
        String r121 = ((Gson) access$getSGson$delegate$cp().getValue()).toJson(r110);     // Catch: Throwable -> L53
        ConcurrentHashMap<String, String> r122 = this.ext;
        if (r122 != null) goto L51;
        r122 = new ConcurrentHashMap();
        this.ext = r122;
    L51:
        r122.put(KEY_ENTITY_FALLBACK_JSON, r121);
        r122.put(KEY_ENTITY_FALLBACK_TYPE, r111);
        this.entityWrittenToFallbackOnly = true;
        return;
    L53:
        th = move-exception;
        th.getMessage();
        return;
    L17:
        r117 = r110 instanceof Object[];
        goto L19
    L5:
        r100 = r110;
        goto L6
    }
}
