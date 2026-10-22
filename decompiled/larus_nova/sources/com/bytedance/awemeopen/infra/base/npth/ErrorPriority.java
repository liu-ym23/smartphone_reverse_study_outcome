package com.bytedance.awemeopen.infra.base.npth;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/npth/ErrorPriority;", "", "", "priorityNum", "I", "getPriorityNum", "()I", "p0", "p1", "p2", "p3", "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final enum ErrorPriority extends Enum<ErrorPriority> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorPriority[] f198709a = null;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final ErrorPriority f198710p0 = null;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final ErrorPriority f198711p1 = null;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public static final ErrorPriority f198712p2 = null;

    /* JADX INFO: renamed from: p3, reason: collision with root package name */
    public static final ErrorPriority f198713p3 = null;
    private final int priorityNum;

    public static ErrorPriority valueOf(String r100) {
        return (ErrorPriority) a.a(ErrorPriority.class, r100);
    }

    public static ErrorPriority[] values() {
        return (ErrorPriority[]) f198709a.clone();
    }

    static {
        ErrorPriority r100 = new ErrorPriority("p0", 0, 0);
        f198710p0 = r100;
        ErrorPriority r101 = new ErrorPriority("p1", 1, 1);
        f198711p1 = r101;
        ErrorPriority r102 = new ErrorPriority("p2", 2, 2);
        f198712p2 = r102;
        ErrorPriority r103 = new ErrorPriority("p3", 3, 3);
        f198713p3 = r103;
        f198709a = new ErrorPriority[]{r100, r101, r102, r103};
    }

    public final int getPriorityNum() {
        return this.priorityNum;
    }

    public ErrorPriority(String r100, int r101, int r102) {
        super(r100, r101);
        this.priorityNum = r102;
    }
}
