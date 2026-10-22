package com.bytedance.ttcnpa;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ttcnpa/ArcHandle;", "", "()V", "LongHandle", "Lcom/bytedance/ttcnpa/ArcHandle$LongHandle;", "ttcnpa_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ArcHandle {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/ttcnpa/ArcHandle$LongHandle;", "Lcom/bytedance/ttcnpa/ArcHandle;", "ttcnpa_release"}, k = 1, mv = {1, 7, 1})
    public static final class LongHandle extends ArcHandle {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f271030a;

        public LongHandle(long r100) {
            super(0);
            this.f271030a = r100;
        }
    }

    private ArcHandle() {
    }

    public /* synthetic */ ArcHandle(int r100) {
        this();
    }
}
