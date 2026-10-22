package po5;

import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelItemData;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.impl.view.TtsOptionsView;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements hw4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mo5.g f530064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TtsOptionsView f530065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ mo5.a f530066c;

    public static final class a implements mo5.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f530067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ mo5.a f530068b;

        public a(float r100, mo5.a r101) {
            this.f530067a = r100;
            this.f530068b = r101;
        }

        @Override // mo5.b
        public final void a(TtsResult r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            tt5.a.h("TtsChangeSpeedCommand", "handleAction, onClick speed: " + this.f530067a + ", result: " + r100);
            mo5.a r101 = this.f530068b;
            if (r101 == null) goto L6;
            r101.g(r100);
            return;
        }
    }

    @Override // hw4.d
    public final void a(int r100, CommonMorePanelItemData r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Float r102 = StringsKt.toFloatOrNull(r101.f216780a);
        if (r102 == null) goto L5;
        float r103 = r102.floatValue();
    L6:
        this.f530064a.k(r103, new a(r103, this.f530066c));
        this.f530065b.dismissAllowingStateLoss();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r104 = DialogFragmentLancet.sLastShowStack;
        if (r104 == null) goto L16;
        com.bytedance.crash.d.d(r104, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L16:
        return;
    L5:
        r103 = 1.0f;
        goto L6
    }

    public d(mo5.g r100, TtsOptionsView r101, mo5.a r102) {
        this.f530064a = r100;
        this.f530065b = r101;
        this.f530066c = r102;
    }
}
