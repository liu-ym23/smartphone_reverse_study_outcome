package com.bytedance.ee.bear.office.list.adapter;

import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEventSource;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ OfficeLongPressActionContextFactory a;
    public final /* synthetic */ oj5.b b;
    public final /* synthetic */ Document c;
    public final /* synthetic */ OfficeSpaceItem d;
    public final /* synthetic */ Fragment e;
    public final /* synthetic */ OfficeSpaceEventSource f;
    public final /* synthetic */ com.bytedance.ee.bear.office.export.space.h g;
    public final /* synthetic */ com.bytedance.ee.bear.office.export.space.j h;
    public final /* synthetic */ com.bytedance.ee.bear.more.office.e i;
    public final /* synthetic */ v j;
    public final /* synthetic */ x k;

    public r(OfficeLongPressActionContextFactory r1, oj5.b r2, Document r3, OfficeSpaceItem r4, Fragment r5, OfficeSpaceEventSource r6, com.bytedance.ee.bear.office.export.space.h r7, com.bytedance.ee.bear.office.export.space.j r8, com.bytedance.ee.bear.more.office.e r9, v r10, x r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }

    public final void accept(Object r15) {
        ShareFolderUserPermission r2 = (ShareFolderUserPermission) r15;
        OfficeLongPressActionContextFactory r3 = this.a;
        r3.g.post(new q(this.b, r2, r3, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k));
    }
}
