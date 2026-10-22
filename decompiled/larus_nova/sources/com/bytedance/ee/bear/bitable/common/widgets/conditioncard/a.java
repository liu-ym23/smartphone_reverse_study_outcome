package com.bytedance.ee.bear.bitable.common.widgets.conditioncard;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements ConditionListView.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f209918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f209919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f209920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f209921d;

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public final /* synthetic */ String getCallbackId() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public final /* synthetic */ Boolean isChecked() {
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public final Integer getRightIconRes() {
        return Integer.valueOf(R.drawable.ud_icon_down_bold_outlined);
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public final CharSequence getHintTitle() {
        return this.f209919b;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public final Integer getIconRes() {
        return this.f209920c;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public final CharSequence getTitle() {
        return this.f209918a;
    }

    @Override // com.bytedance.ee.bear.bitable.common.widgets.conditioncard.ConditionListView.b
    public final boolean isSync() {
        return this.f209921d;
    }

    public a(CharSequence r100, CharSequence r101, Integer r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = false;
    L14:
        Intrinsics.checkNotNullParameter(r101, "hintTitle");
        this.f209918a = r100;
        this.f209919b = r101;
        this.f209920c = r102;
        this.f209921d = r103;
    }
}
