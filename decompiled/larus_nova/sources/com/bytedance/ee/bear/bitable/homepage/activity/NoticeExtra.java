package com.bytedance.ee.bear.bitable.homepage.activity;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R.\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/activity/NoticeExtra;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "imageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getImageList", "()Ljava/util/ArrayList;", "setImageList", "(Ljava/util/ArrayList;)V", "tableExtra", "Lcom/bytedance/ee/bear/bitable/homepage/activity/TableExtra;", "getTableExtra", "()Lcom/bytedance/ee/bear/bitable/homepage/activity/TableExtra;", "setTableExtra", "(Lcom/bytedance/ee/bear/bitable/homepage/activity/TableExtra;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoticeExtra implements NonProguard {

    @JSONField(name = "image_list")
    private ArrayList<String> imageList;

    @JSONField(name = "notify_extra")
    private TableExtra tableExtra;

    public NoticeExtra() {
        this.imageList = new ArrayList();
    }

    public final ArrayList<String> getImageList() {
        return this.imageList;
    }

    public final TableExtra getTableExtra() {
        return this.tableExtra;
    }

    public final void setImageList(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.imageList = r100;
    }

    public final void setTableExtra(TableExtra r100) {
        this.tableExtra = r100;
    }
}
