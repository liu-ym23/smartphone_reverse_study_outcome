package com.ss.android.lark.log.alog;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B?\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/log/alog/ProcessItemConfig;", "", "maxSize", "", "level", "limitTag", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "limitMsgRegex", "<init>", "(IILjava/util/ArrayList;Ljava/lang/String;)V", "getMaxSize", "()I", "setMaxSize", "(I)V", "getLevel", "setLevel", "getLimitTag", "()Ljava/util/ArrayList;", "setLimitTag", "(Ljava/util/ArrayList;)V", "getLimitMsgRegex", "()Ljava/lang/String;", "setLimitMsgRegex", "(Ljava/lang/String;)V", "lark-logger_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProcessItemConfig {
    private int level;
    private String limitMsgRegex;
    private ArrayList<String> limitTag;
    private int maxSize;

    public ProcessItemConfig() {
        this(0, 0, null, null, 15, null);
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getLimitMsgRegex() {
        return this.limitMsgRegex;
    }

    public final ArrayList<String> getLimitTag() {
        return this.limitTag;
    }

    public final int getMaxSize() {
        return this.maxSize;
    }

    public final void setLevel(int r100) {
        this.level = r100;
    }

    public final void setLimitMsgRegex(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.limitMsgRegex = r100;
    }

    public final void setLimitTag(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.limitTag = r100;
    }

    public final void setMaxSize(int r100) {
        this.maxSize = r100;
    }

    public ProcessItemConfig(int r100, int r101, ArrayList<String> r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "limitTag");
        Intrinsics.checkNotNullParameter(r103, "limitMsgRegex");
        this.maxSize = r100;
        this.level = r101;
        this.limitTag = r102;
        this.limitMsgRegex = r103;
    }

    public /* synthetic */ ProcessItemConfig(int r100, int r101, ArrayList r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 240;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 4;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = new ArrayList();
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = "";
    L14:
        this(r100, r101, r102, r103);
    }
}
