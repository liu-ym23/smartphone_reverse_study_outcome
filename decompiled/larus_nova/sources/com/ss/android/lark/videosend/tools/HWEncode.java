package com.ss.android.lark.videosend.tools;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0004\b\u0006\u0010\u0007R.\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/videosend/tools/HWEncode;", "", "blackListPlus", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<init>", "(Ljava/util/ArrayList;)V", "getBlackListPlus", "()Ljava/util/ArrayList;", "setBlackListPlus", "videosend_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HWEncode {

    @SerializedName("black_list_plus")
    private ArrayList<String> blackListPlus;

    /* JADX WARN: Multi-variable type inference failed */
    public HWEncode() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final ArrayList<String> getBlackListPlus() {
        return this.blackListPlus;
    }

    public HWEncode(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "blackListPlus");
        this.blackListPlus = r100;
    }

    public final void setBlackListPlus(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.blackListPlus = r100;
    }

    public /* synthetic */ HWEncode(ArrayList r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ArrayList();
    L5:
        this(r100);
    }
}
