package z95;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.bytedance.ee.bear.drive.view.preview.retryview.FailedToRetryView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class h implements h95.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FailedToRetryView f571017a;

    @Override // h95.b
    public final void a() {
        FailedToRetryView r100 = this.f571017a;
        r100.f225178e = true;
        r100.showPrimaryAction(!TextUtils.isEmpty(r100.f225175b));
        FailedToRetryView r101 = this.f571017a;
        r101.showSecondaryAction(true ^ TextUtils.isEmpty(r101.f225176c));
        this.f571017a.setImageSizeResource(R.dimen.ccm_emptystate_image_size_middle);
        this.f571017a.getImageView().requestLayout();
        c();
        this.f571017a.setDescTextAppearance(R.style.UDText_Body2);
    }

    @Override // h95.b
    public final void b() {
        FailedToRetryView r100 = this.f571017a;
        r100.f225178e = false;
        r100.showPrimaryAction(false);
        this.f571017a.showSecondaryAction(false);
        this.f571017a.setImageSizeResource(R.dimen.ccm_emptystate_image_size_small);
        this.f571017a.getImageView().requestLayout();
        c();
        this.f571017a.setDescTextAppearance(R.style.UDText_Caption1);
        View r101 = this.f571017a.findViewById(R.id.desc);
        if ((r101 instanceof TextView) == false) goto L6;
        r101.setTag(R.id.drive_preview_block_fun_location_tag, Boolean.TRUE);
        return;
    }

    public final void c() {
        if (Boolean.FALSE.equals(this.f571017a.f225180g.liveOuterNetState().getValue()) == false) goto L5;
        CharSequence r100 = this.f571017a.getResources().getString(R.string.CreationMobile_Common_NoInternet);
    L9:
        tt5.a.h("FailedToRetryView", "observeBlockState: " + r100);
        this.f571017a.setDesc(r100);
        return;
    L5:
        this.f571017a.getClass();
        if (FailedToRetryView.e() == true) goto L8;
        r100 = FailedToRetryView.b(this.f571017a);
        goto L9
    L8:
        r100 = FailedToRetryView.c(this.f571017a);
        goto L9
    }

    public h(FailedToRetryView r100) {
        this.f571017a = r100;
    }
}
