package com.ss.android.lark.forseti.node.piece;

import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.Fragment;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class d<O> implements ActivityResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ForsetiNodePiece f424571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Fragment f424572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f424573c;

    public d(ForsetiNodePiece r100, Fragment r101, String r102) {
        this.f424571a = r100;
        this.f424572b = r101;
        this.f424573c = r102;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public final void onActivityResult(Object r100) {
        Map r101 = (Map) r100;
        String[] r102 = (String[]) r101.keySet().toArray(new String[0]);
        ArrayList r103 = new ArrayList(r101.values());
        int[] r104 = new int[r103.size()];
        int r105 = r103.size();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L9;
        if (((Boolean) ListProtector.get(r103, r106)).booleanValue() == false) goto L7;
        int r107 = 0;
    L8:
        r104[r106] = r107;
        r106 = r106 + 1;
        goto L3
    L7:
        r107 = -1;
        goto L8
    L9:
        ForsetiNodePiece.b r108 = this.f424571a.f424549r.pollFirst();
        if (r108 == null) goto L17;
        int r109 = r108.f424559b;
        this.f424572b.onRequestPermissionsResult(r109, r102, r104);
        ForsetiNodePiece.e(this.f424571a, this.f424573c);
        return;
    }
}
