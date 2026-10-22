package com.bytedance.ee.bear.bitable.cardview.viewsetting;

import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CardViewSettingFragment$initSelectFieldList$settingFieldListAdapter$1 f209258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TextView f209259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f209260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ TextView f209261d;

    public e(CardViewSettingFragment$initSelectFieldList$settingFieldListAdapter$1 r100, TextView r101, RecyclerView r102, TextView r103) {
        this.f209258a = r100;
        this.f209259b = r101;
        this.f209260c = r102;
        this.f209261d = r103;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        List r101 = (List) r100;
        CardViewSettingFragment$initSelectFieldList$settingFieldListAdapter$1 r102 = this.f209258a;
        Intrinsics.checkNotNull(r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, SlcCommonAction.KEY_PARAMS);
        RecyclerView r103 = r102.f209247e;
        if (r103 == null) goto L5;
        r103.post(new uq4.c(r102, r101));
    L5:
        TextView r104 = this.f209259b;
        int r105 = 0;
        if (r101.isEmpty() == false) goto L8;
        int r106 = 0;
    L9:
        r104.setVisibility(r106);
        RecyclerView r107 = this.f209260c;
        if ((!r101.isEmpty()) == false) goto L12;
        int r108 = 0;
    L13:
        r107.setVisibility(r108);
        TextView r109 = this.f209261d;
        if (r101.size() == 9) goto L17;
        r105 = 8;
    L17:
        r109.setVisibility(r105);
        return;
    L12:
        r108 = 8;
        goto L13
    L8:
        r106 = 8;
        goto L9
    }
}
