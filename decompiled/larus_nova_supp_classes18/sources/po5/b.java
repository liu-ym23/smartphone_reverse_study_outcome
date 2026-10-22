package po5;

import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelItemData;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.impl.view.TtsOptionsView;
import com.bytedance.ee.bear.tts.tone.TtsToneBean;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements hw4.d {
    public final /* synthetic */ List<TtsToneBean> a;
    public final /* synthetic */ mo5.a b;
    public final /* synthetic */ TtsOptionsView c;
    public final /* synthetic */ mo5.g d;

    public static final class a implements mo5.b {
        public final /* synthetic */ CommonMorePanelItemData a;
        public final /* synthetic */ mo5.g b;
        public final /* synthetic */ mo5.g c;
        public final /* synthetic */ mo5.a d;

        /* JADX INFO: renamed from: po5.b$a$a, reason: collision with other inner class name */
        public static final class C0292a implements mo5.b {
            public final /* synthetic */ CommonMorePanelItemData a;
            public final /* synthetic */ mo5.g b;
            public final /* synthetic */ mo5.a c;

            public C0292a(CommonMorePanelItemData r1, mo5.g r2, mo5.a r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // mo5.b
            public final void a(TtsResult r3) {
                Intrinsics.checkNotNullParameter(r3, "reloadResult");
                tt5.a.h("TtsChangeSpeakerCommand", "handleAction, onClick tone: " + this.a.a + ", for item: " + this.b + ", reload result: " + r3);
                mo5.a r0 = this.c;
                if (r0 == null) goto L6;
                r0.g(r3);
                return;
            }
        }

        public a(CommonMorePanelItemData r1, mo5.g r2, mo5.g r3, mo5.a r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        @Override // mo5.b
        public final void a(TtsResult r6) {
            Intrinsics.checkNotNullParameter(r6, "selectToneResult");
            tt5.a.h("TtsChangeSpeakerCommand", "handleAction, onClick tone: " + this.a.a + ", for item: " + this.b + ", select result: " + r6);
            if (Intrinsics.areEqual(this.b.a(), this.c.a()) == true) goto L5;
            return;
        L5:
            mo5.a r0 = this.d;
            if (r0 == null) goto L9;
            r0.g(r6);
        L9:
            if (r6.a() == false) goto L12;
            this.c.w(TtsLoadScene.SWITCH_TONE, new C0292a(this.a, this.b, this.d));
            return;
        }
    }

    public final void a(int r6, CommonMorePanelItemData r7) {
        Intrinsics.checkNotNullParameter(r7, ResourceData.KEY_TYPE);
        Iterator<T> r8 = this.a.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Object r0 = r8.next();
        if (Intrinsics.areEqual(((TtsToneBean) r0).getToneId(), r7.a) == false) goto L4;
    L9:
        TtsToneBean r1 = (TtsToneBean) r0;
        if (r1 != null) goto L13;
        tt5.a.k("TtsChangeSpeakerCommand", "handleAction, onClick tone not found: " + r7.a + ", toneBeanList: " + this.a);
        return;
    L13:
        mo5.a r9 = this.b;
        if (r9 == null) goto L29;
        List<mo5.g> r10 = mo5.h.d(r9);
        if (r10 == null) goto L29;
        mo5.g r2 = this.d;
        mo5.a r3 = this.b;
        Iterator<T> r11 = r10.iterator();
    L19:
        if (r11.hasNext() == false) goto L29;
        mo5.g r4 = (mo5.g) r11.next();
        r4.f(r1, new a(r7, r4, r2, r3));
    L29:
        this.c.dismissAllowingStateLoss();     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r12 = DialogFragmentLancet.sLastShowStack;
        if (r12 == null) goto L35;
        com.bytedance.crash.d.d(r12, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L35:
        return;
    L8:
        r0 = null;
        goto L9
    }

    public b(List<TtsToneBean> r1, mo5.a r2, TtsOptionsView r3, mo5.g r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
