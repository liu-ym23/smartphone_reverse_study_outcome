package com.bytedance.ee.bear.widgets;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.core.view.GravityCompat;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class m {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f240229g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f240230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f240231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ml5.b f240232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f240233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f240234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final UDDialog f240235f;

    public static final class a implements fp5.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f240236a;

        public a(Ref.BooleanRef r100) {
            this.f240236a = r100;
        }

        @Override // fp5.a.b
        public final void a(View r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "checkBox");
            this.f240236a.element = !r101;
        }
    }

    public static final class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f240237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f240238b;

        public b(m r100, Ref.BooleanRef r101) {
            this.f240237a = r100;
            this.f240238b = r101;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            ml5.b r102 = this.f240237a.f240232c;
            int r103 = m.f240229g;
            r102.b("PREF_KEY_REMIND", Boolean.valueOf(this.f240238b.element));
            this.f240237a.f240231b.onContinue();
            this.f240237a.f240234e = true;
        }
    }

    public static final class c implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f240239a;

        public c(m r100) {
            this.f240239a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            m r101 = this.f240239a;
            if (r101.f240234e == true) goto L8;
            f r102 = r101.f240233d;
            if (r102 == null) goto L9;
            r102.onCancel();
            return;
        L9:
            return;
        }
    }

    public static final class d {
    }

    public interface e {
        void onContinue();
    }

    public interface f {
        void onCancel();
    }

    static {
    }

    public final void a() {
        UDDialog r100 = this.f240235f;
        if (r100 != null) goto L5;
        return;
    L5:
        if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(r100);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        DialogLancet.beforeDialogShow(r100);
        r100.show();
        DialogLancet.afterDialogShow(r100);
    }

    public final Context getContext() {
        return this.f240230a;
    }

    public m(Context r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "confirmCallBack");
        this.f240230a = r100;
        this.f240231b = r101;
        ml5.b r102 = new ml5.b("download_sd_pref");
        this.f240232c = r102;
        if (((Boolean) r102.a("PREF_KEY_REMIND", Boolean.TRUE)).booleanValue() == false) goto L5;
        Ref.BooleanRef r103 = new Ref.BooleanRef();
        r103.element = true;
        fp5.a r104 = new fp5.a(r100).title(R.string.Doc_Widget_Tip).titleBold(true).titleGravity(17).message(R.string.Doc_Widget_StoreFileToSDCard).messageGravity(GravityCompat.START);
        r104.f478270a = false;
        r104.a(r100.getString(R.string.Doc_Widget_NotRemind));
        r104.f478273d = R.color.text_caption;
        a r105 = new a(r103);
        Intrinsics.checkNotNullParameter(r105, "value");
        r104.f478275f = r105;
        this.f240235f = r104.addActionButton(R.id.ud_dialog_btn_primary, R.string.Doc_Widget_Continue, new b(this, r103)).addActionButton(R.id.ud_dialog_btn_secondary, R.string.CreationMobile_Docs_Cancel_Button, null).onDismissListener(new c(this)).build();
        return;
    L5:
        r101.onContinue();
    }
}
