package com.bytedance.lark.lark_markdown_render_android;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lark_markdown_render.proto.FuncParamsX57675f1c0efe42b7;
import lark_markdown_render.proto.FuncParamsX8cff7ec6f21a8edd;
import lark_markdown_render.proto.FuncParamsXc67a973e53572a63;
import lark_markdown_render.proto.FuncParamsXe6c042c351c9bc6a;
import lark_markdown_render.proto.FuncParamsXe7073a5413ebfa76;
import lark_markdown_render.proto.FuncReturnX011dd45b533eb24e;
import lark_markdown_render.proto.FuncReturnX042ac4d5a07e821f;
import lark_markdown_render.proto.MoltenContextExtra;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004J+\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0011H\u0096\u0001J)\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J;\u0010 \u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u0013H\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b%\u0010&J1\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\fH\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u0018\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020/2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J+\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u00103\u001a\u00020\nH\u0096\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u0014\u0010\u0003\u001a\u00020\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/MovableCallbackProxy;", "Lcom/bytedance/lark/lark_markdown_render_android/MovableCallback;", "Lcom/bytedance/lark/lark_markdown_render_android/MoltenFFICallback;", "callbackObj", "(Lcom/bytedance/lark/lark_markdown_render_android/MovableCallback;)V", "getCallbackObj", "()Lcom/bytedance/lark/lark_markdown_render_android/MovableCallback;", "eventClick", "", "instanceId", "Lkotlin/UInt;", "schema", "", "payload", "eventClick-OzbTU-A", "(ILjava/lang/String;Ljava/lang/String;)V", "getFontPrefixPathCandidates", "", "getScrollIslandScrollOffset", "", "canvasId", "islandId", "getScrollIslandScrollOffset-feOb9K0", "(II)Ljava/util/List;", "invokeEventClickXd2fec90d", "", "params", "invokeGetFontPrefixPathCandidatesX6e0b51ed", "invokeGetScrollIslandScrollOffsetX9fe99c63", "invokeMarkHighlightUpdateXc412a194", "invokeMeasureAttachmentX485df39d", "invokeRegisterFontX67e88915", "markHighlightUpdate", "x", "y", "width", "height", "markHighlightUpdate-iyaXS9w", "(IFFFF)V", "measureAttachment", "typeId", "containerWidth", "propertyString", "measureAttachment-OzbTU-A", "(IFLjava/lang/String;)Ljava/util/List;", "onInvoke", "methodId", "", "registerFont", "name", "path", "ttcIndex", "registerFont-jXDDuk8", "(Ljava/lang/String;Ljava/lang/String;I)V", "Companion", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class MovableCallbackProxy implements MovableCallback, MoltenFFICallback {
    public static final Companion Companion = null;
    private final MovableCallback callbackObj;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/MovableCallbackProxy$Companion;", "", "()V", "obtain", "", "callback", "Lcom/bytedance/lark/lark_markdown_render_android/MovableCallback;", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final long obtain(MovableCallback r3) {
            Intrinsics.checkNotNullParameter(r3, "callback");
            MovableCallbackProxy r0 = new MovableCallbackProxy(r3, null);
            return CallbackInstance.INSTANCE.registerInstance(r0);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ MovableCallbackProxy(MovableCallback r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MovableCallback
    /* JADX INFO: renamed from: eventClick-OzbTU-A */
    public void mo495eventClickOzbTUA(int r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        Intrinsics.checkNotNullParameter(r4, "payload");
        this.callbackObj.mo495eventClickOzbTUA(r2, r3, r4);
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MovableCallback
    public List<String> getFontPrefixPathCandidates() {
        return this.callbackObj.getFontPrefixPathCandidates();
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MovableCallback
    /* JADX INFO: renamed from: getScrollIslandScrollOffset-feOb9K0 */
    public List<Float> mo496getScrollIslandScrollOffsetfeOb9K0(int r2, int r3) {
        return this.callbackObj.mo496getScrollIslandScrollOffsetfeOb9K0(r2, r3);
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MovableCallback
    /* JADX INFO: renamed from: markHighlightUpdate-iyaXS9w */
    public void mo497markHighlightUpdateiyaXS9w(int r7, float r8, float r9, float r10, float r11) {
        this.callbackObj.mo497markHighlightUpdateiyaXS9w(r7, r8, r9, r10, r11);
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MovableCallback
    /* JADX INFO: renamed from: measureAttachment-OzbTU-A */
    public List<Float> mo498measureAttachmentOzbTUA(int r2, float r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "propertyString");
        return this.callbackObj.mo498measureAttachmentOzbTUA(r2, r3, r4);
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MovableCallback
    /* JADX INFO: renamed from: registerFont-jXDDuk8 */
    public void mo499registerFontjXDDuk8(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "path");
        this.callbackObj.mo499registerFontjXDDuk8(r2, r3, r4);
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MoltenFFICallback
    public /* bridge */ /* synthetic */ Object getCallbackObj() {
        return getCallbackObj();
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MoltenFFICallback
    public MovableCallback getCallbackObj() {
        return this.callbackObj;
    }

    private MovableCallbackProxy(MovableCallback r1) {
        this.callbackObj = r1;
    }

    private final byte[] invokeEventClickXd2fec90d(byte[] r6) {
        Object r7 = FuncParamsX57675f1c0efe42b7.ADAPTER.decode(r6);
        Intrinsics.checkNotNull(r7);
        FuncParamsX57675f1c0efe42b7 r8 = (FuncParamsX57675f1c0efe42b7) r7;
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        Object r1 = r0.onInvokeeStart(r8._molten_ctx);
        mo495eventClickOzbTUA(UInt.constructor-impl(r8.instance_id.intValue()), r8.schema, r8.payload);     // Catch: Throwable -> L6 Exception -> L8
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L6 Exception -> L8
        MoltenContextExtra r10 = new MoltenContextExtra(null);     // Catch: Throwable -> L6 Exception -> L8
        Pair r2 = new Pair(0L, MoltenContextExtra.ADAPTER.encode(r10));     // Catch: Throwable -> L6 Exception -> L8
        r0.onInvokeeEnd(r1);
        return (byte[]) r2.getSecond();
    L8:
        e = move-exception;
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        MoltenFfiLibLarkMarkdownRender.Companion.onInvokeeEnd(r1);
        throw th;
    }

    private final byte[] invokeGetFontPrefixPathCandidatesX6e0b51ed(byte[] r6) {
        Object r7 = MoltenContextExtra.ADAPTER.decode(r6);
        Intrinsics.checkNotNull(r7);
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        Object r8 = r0.onInvokeeStart(((MoltenContextExtra) r7)._molten_ctx);
        FuncReturnX011dd45b533eb24e r2 = new FuncReturnX011dd45b533eb24e(getFontPrefixPathCandidates(), null);     // Catch: Throwable -> L6 Exception -> L8
        Pair r1 = new Pair(0L, FuncReturnX011dd45b533eb24e.ADAPTER.encode(r2));     // Catch: Throwable -> L6 Exception -> L8
        r0.onInvokeeEnd(r8);
        return (byte[]) r1.getSecond();
    L8:
        e = move-exception;
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        MoltenFfiLibLarkMarkdownRender.Companion.onInvokeeEnd(r8);
        throw th;
    }

    private final byte[] invokeGetScrollIslandScrollOffsetX9fe99c63(byte[] r6) {
        Object r7 = FuncParamsXe6c042c351c9bc6a.ADAPTER.decode(r6);
        Intrinsics.checkNotNull(r7);
        FuncParamsXe6c042c351c9bc6a r8 = (FuncParamsXe6c042c351c9bc6a) r7;
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        Object r1 = r0.onInvokeeStart(r8._molten_ctx);
        FuncReturnX042ac4d5a07e821f r2 = new FuncReturnX042ac4d5a07e821f(mo496getScrollIslandScrollOffsetfeOb9K0(UInt.constructor-impl(r8.canvas_id.intValue()), UInt.constructor-impl(r8.island_id.intValue())), null);     // Catch: Throwable -> L6 Exception -> L8
        Pair r9 = new Pair(0L, FuncReturnX042ac4d5a07e821f.ADAPTER.encode(r2));     // Catch: Throwable -> L6 Exception -> L8
        r0.onInvokeeEnd(r1);
        return (byte[]) r9.getSecond();
    L8:
        e = move-exception;
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        MoltenFfiLibLarkMarkdownRender.Companion.onInvokeeEnd(r1);
        throw th;
    }

    private final byte[] invokeMarkHighlightUpdateXc412a194(byte[] r10) {
        Object r11 = FuncParamsXe7073a5413ebfa76.ADAPTER.decode(r10);
        Intrinsics.checkNotNull(r11);
        FuncParamsXe7073a5413ebfa76 r12 = (FuncParamsXe7073a5413ebfa76) r11;
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        Object r1 = r0.onInvokeeStart(r12._molten_ctx);
        mo497markHighlightUpdateiyaXS9w(UInt.constructor-impl(r12.canvas_id.intValue()), r12.x.floatValue(), r12.y.floatValue(), r12.width.floatValue(), r12.height.floatValue());     // Catch: Throwable -> L6 Exception -> L8
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L6 Exception -> L8
        MoltenContextExtra r14 = new MoltenContextExtra(null);     // Catch: Throwable -> L6 Exception -> L8
        Pair r2 = new Pair(0L, MoltenContextExtra.ADAPTER.encode(r14));     // Catch: Throwable -> L6 Exception -> L8
        r0.onInvokeeEnd(r1);
        return (byte[]) r2.getSecond();
    L8:
        e = move-exception;
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        MoltenFfiLibLarkMarkdownRender.Companion.onInvokeeEnd(r1);
        throw th;
    }

    private final byte[] invokeMeasureAttachmentX485df39d(byte[] r6) {
        Object r7 = FuncParamsX8cff7ec6f21a8edd.ADAPTER.decode(r6);
        Intrinsics.checkNotNull(r7);
        FuncParamsX8cff7ec6f21a8edd r8 = (FuncParamsX8cff7ec6f21a8edd) r7;
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        Object r1 = r0.onInvokeeStart(r8._molten_ctx);
        FuncReturnX042ac4d5a07e821f r2 = new FuncReturnX042ac4d5a07e821f(mo498measureAttachmentOzbTUA(UInt.constructor-impl(r8.type_id.intValue()), r8.container_width.floatValue(), r8.property_string), null);     // Catch: Throwable -> L6 Exception -> L8
        Pair r9 = new Pair(0L, FuncReturnX042ac4d5a07e821f.ADAPTER.encode(r2));     // Catch: Throwable -> L6 Exception -> L8
        r0.onInvokeeEnd(r1);
        return (byte[]) r9.getSecond();
    L8:
        e = move-exception;
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        MoltenFfiLibLarkMarkdownRender.Companion.onInvokeeEnd(r1);
        throw th;
    }

    private final byte[] invokeRegisterFontX67e88915(byte[] r6) {
        Object r7 = FuncParamsXc67a973e53572a63.ADAPTER.decode(r6);
        Intrinsics.checkNotNull(r7);
        FuncParamsXc67a973e53572a63 r8 = (FuncParamsXc67a973e53572a63) r7;
        MoltenFfiLibLarkMarkdownRender.Companion r0 = MoltenFfiLibLarkMarkdownRender.Companion;
        Object r1 = r0.onInvokeeStart(r8._molten_ctx);
        mo499registerFontjXDDuk8(r8.name, r8.path, UInt.constructor-impl(r8.ttc_index.intValue()));     // Catch: Throwable -> L6 Exception -> L8
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L6 Exception -> L8
        MoltenContextExtra r10 = new MoltenContextExtra(null);     // Catch: Throwable -> L6 Exception -> L8
        Pair r2 = new Pair(0L, MoltenContextExtra.ADAPTER.encode(r10));     // Catch: Throwable -> L6 Exception -> L8
        r0.onInvokeeEnd(r1);
        return (byte[]) r2.getSecond();
    L8:
        e = move-exception;
        throw e;     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        MoltenFfiLibLarkMarkdownRender.Companion.onInvokeeEnd(r1);
        throw th;
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MoltenFFICallback
    public byte[] onInvoke(long r4, byte[] r6) {
        Intrinsics.checkNotNullParameter(r6, "params");
        if (r4 != 4710922851703759252L) goto L6;
        return invokeMarkHighlightUpdateXc412a194(r6);
    L6:
        if (r4 != (-6984711643076196075L)) goto L9;
        return invokeRegisterFontX67e88915(r6);
    L9:
        if (r4 != 8300712863626873101L) goto L12;
        return invokeEventClickXd2fec90d(r6);
    L12:
        if (r4 != 5170887932666027107L) goto L15;
        return invokeGetScrollIslandScrollOffsetX9fe99c63(r6);
    L15:
        if (r4 != (-1772830105575665171L)) goto L18;
        return invokeGetFontPrefixPathCandidatesX6e0b51ed(r6);
    L18:
        if (r4 == (-4105389903651671139L)) goto L20;
        MethodId.m490methodKeyimpl(MethodId.m486constructorimpl(r4));
        throw new Exception("onInvoke $[methodId] $[desc]");
    L20:
        return invokeMeasureAttachmentX485df39d(r6);
    }

    @Override // com.bytedance.lark.lark_markdown_render_android.MoltenFFICallback
    public void onInvokeAsync(long r1, long r3, byte[] r5) {
        MoltenFFICallback.DefaultImpls.onInvokeAsync(this, r1, r3, r5);
    }
}
