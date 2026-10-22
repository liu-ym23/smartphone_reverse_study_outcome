package com.lark.kmp.storage.kv;

import androidx.webkit.WebViewFeature;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/lark/kmp/storage/kv/Mode;", "", "mode", "", "<init>", "(Ljava/lang/String;II)V", "getMode", "()I", "SINGLE_PROCESS", WebViewFeature.MULTI_PROCESS, "lark-storage-kmp_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Mode extends Enum<Mode> {
    public static final Mode MULTI_PROCESS = null;
    public static final Mode SINGLE_PROCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Mode[] f282702a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f282703b = null;
    private final int mode;

    public static EnumEntries<Mode> getEntries() {
        return f282703b;
    }

    static {
        Mode r100 = new Mode("SINGLE_PROCESS", 0, 1);
        SINGLE_PROCESS = r100;
        Mode r101 = new Mode(WebViewFeature.MULTI_PROCESS, 1, 2);
        MULTI_PROCESS = r101;
        Mode[] r102 = {r100, r101};
        f282702a = r102;
        f282703b = EnumEntriesKt.enumEntries(r102);
    }

    public static Mode[] values() {
        return (Mode[]) f282702a.clone();
    }

    public final int getMode() {
        return this.mode;
    }

    public static Mode valueOf(String r100) {
        return (Mode) r27.a.a(Mode.class, r100);
    }

    public Mode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mode = r102;
    }
}
