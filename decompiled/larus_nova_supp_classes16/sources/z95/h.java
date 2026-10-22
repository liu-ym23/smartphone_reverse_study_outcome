package z95;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h implements h95.b {
    public final /* synthetic */ FailedToRetryView a;

    @Override // h95.b
    public final void a() {
        FailedToRetryView r0 = this.a;
        r0.e = true;
        r0.showPrimaryAction(!TextUtils.isEmpty(r0.b));
        FailedToRetryView r1 = this.a;
        r1.showSecondaryAction(true ^ TextUtils.isEmpty(r1.c));
        this.a.setImageSizeResource(2131165486);
        this.a.getImageView().requestLayout();
        c();
        this.a.setDescTextAppearance(2131953910);
    }

    @Override // h95.b
    public final void b() {
        FailedToRetryView r0 = this.a;
        r0.e = false;
        r0.showPrimaryAction(false);
        this.a.showSecondaryAction(false);
        this.a.setImageSizeResource(2131165487);
        this.a.getImageView().requestLayout();
        c();
        this.a.setDescTextAppearance(2131953912);
        View r1 = this.a.findViewById(2131368819);
        if ((r1 instanceof TextView) == false) goto L6;
        r1.setTag(2131370304, Boolean.TRUE);
        return;
    }

    public final void c() {
        if (Boolean.FALSE.equals((Boolean) this.a.g.liveOuterNetState().getValue()) == false) goto L5;
        CharSequence r0 = this.a.getResources().getString(2131887130);
    L9:
        tt5.a.h("FailedToRetryView", "observeBlockState: " + r0);
        this.a.setDesc(r0);
        return;
    L5:
        this.a.getClass();
        if (FailedToRetryView.e() == true) goto L8;
        r0 = FailedToRetryView.b(this.a);
        goto L9
    L8:
        r0 = FailedToRetryView.c(this.a);
        goto L9
    }

    public h(FailedToRetryView r1) {
        this.a = r1;
    }
}
