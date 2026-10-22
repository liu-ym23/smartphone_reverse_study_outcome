package po5;

import com.bytedance.ee.bear.content.common.morepanel.CommonMorePanelItemData;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import com.bytedance.ee.bear.tts.impl.view.TtsOptionsView;
import com.bytedance.ee.bear.tts.tone.TtsToneBean;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements hw4.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<TtsToneBean> f530052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ mo5.a f530053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TtsOptionsView f530054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ mo5.g f530055d;

    public static final class a implements mo5.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommonMorePanelItemData f530056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ mo5.g f530057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ mo5.g f530058c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ mo5.a f530059d;

        /* JADX INFO: renamed from: po5.b$a$a, reason: collision with other inner class name */
        public static final class C7219a implements mo5.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CommonMorePanelItemData f530060a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ mo5.g f530061b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ mo5.a f530062c;

            public C7219a(CommonMorePanelItemData r100, mo5.g r101, mo5.a r102) {
                this.f530060a = r100;
                this.f530061b = r101;
                this.f530062c = r102;
            }

            @Override // mo5.b
            public final void a(TtsResult r100) {
                Intrinsics.checkNotNullParameter(r100, "reloadResult");
                tt5.a.h("TtsChangeSpeakerCommand", "handleAction, onClick tone: " + this.f530060a.f216780a + ", for item: " + this.f530061b + ", reload result: " + r100);
                mo5.a r101 = this.f530062c;
                if (r101 == null) goto L6;
                r101.g(r100);
                return;
            }
        }

        public a(CommonMorePanelItemData r100, mo5.g r101, mo5.g r102, mo5.a r103) {
            this.f530056a = r100;
            this.f530057b = r101;
            this.f530058c = r102;
            this.f530059d = r103;
        }

        @Override // mo5.b
        public final void a(TtsResult r100) {
            Intrinsics.checkNotNullParameter(r100, "selectToneResult");
            tt5.a.h("TtsChangeSpeakerCommand", "handleAction, onClick tone: " + this.f530056a.f216780a + ", for item: " + this.f530057b + ", select result: " + r100);
            if (Intrinsics.areEqual(this.f530057b.a(), this.f530058c.a()) == true) goto L5;
            return;
        L5:
            mo5.a r101 = this.f530059d;
            if (r101 == null) goto L9;
            r101.g(r100);
        L9:
            if (r100.a() == false) goto L12;
            this.f530058c.w(TtsLoadScene.SWITCH_TONE, new C7219a(this.f530056a, this.f530057b, this.f530059d));
            return;
        }
    }

    @Override // hw4.d
    public final void a(int r100, CommonMorePanelItemData r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        Iterator<T> r102 = this.f530052a.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((TtsToneBean) r103).getToneId(), r101.f216780a) == false) goto L4;
    L9:
        TtsToneBean r104 = (TtsToneBean) r103;
        if (r104 != null) goto L13;
        tt5.a.k("TtsChangeSpeakerCommand", "handleAction, onClick tone not found: " + r101.f216780a + ", toneBeanList: " + this.f530052a);
        return;
    L13:
        mo5.a r105 = this.f530053b;
        if (r105 == null) goto L29;
        List<mo5.g> r106 = mo5.h.d(r105);
        if (r106 == null) goto L29;
        mo5.g r107 = this.f530055d;
        mo5.a r108 = this.f530053b;
        Iterator<T> r109 = r106.iterator();
    L19:
        if (r109.hasNext() == false) goto L29;
        mo5.g r110 = (mo5.g) r109.next();
        r110.f(r104, new a(r101, r110, r107, r108));
    L29:
        this.f530054c.dismissAllowingStateLoss();     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r111 = DialogFragmentLancet.sLastShowStack;
        if (r111 == null) goto L35;
        com.bytedance.crash.d.d(r111, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L35:
        return;
    L8:
        r103 = null;
        goto L9
    }

    public b(List<TtsToneBean> r100, mo5.a r101, TtsOptionsView r102, mo5.g r103) {
        this.f530052a = r100;
        this.f530053b = r101;
        this.f530054c = r102;
        this.f530055d = r103;
    }
}
