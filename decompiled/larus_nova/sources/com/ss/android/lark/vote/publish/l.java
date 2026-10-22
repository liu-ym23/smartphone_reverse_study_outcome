package com.ss.android.lark.vote.publish;

import android.text.Editable;
import android.text.TextWatcher;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class l implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OptionViewHolder f445304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ VoteRecycleAdapter f445305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f445306c;

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable r100) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
    }

    public l(OptionViewHolder r100, VoteRecycleAdapter r101, int r102) {
        this.f445304a = r100;
        this.f445305b = r101;
        this.f445306c = r102;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        String r104 = StringsKt.trimStart(r100.toString()).toString();
        int r105 = r100.length() - r104.length();
        if (r104.length() <= 120) goto L8;
        int r106 = (r101 - r105) + r103;
        int r107 = Math.max(0, r106 - r103);
        String r108 = StringsKt.removeRange(r104, RangesKt.until(r107, r106)).toString();
        this.f445304a.f445259a.setText(r108);
        this.f445304a.f445259a.setSelection(r107);
        this.f445305b.f445285b.showToast(UIHelper.mustacheFormat(R.string.Lark_IM_Poll_MaximumCharacterLimit120_ErrorText, "num", BDLocationException.ERROR_LIGHT_LOCATION_UPLOAD_LOCATION_INFO));
        return;
    L8:
        if (r105 <= 0) goto L11;
        this.f445304a.f445259a.setText(r104);
        int r109 = Math.min(Math.max((r101 - r105) + r103, 0), r104.length());
        this.f445304a.f445259a.setSelection(r109);
        return;
    L11:
        g r110 = (g) ListProtector.get(this.f445305b.f445284a, this.f445306c);
        r110.getClass();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r110.f445297b = r104;
        VoteRecycleAdapter.y2(this.f445305b);
        this.f445305b.f445285b.b();
    }
}
