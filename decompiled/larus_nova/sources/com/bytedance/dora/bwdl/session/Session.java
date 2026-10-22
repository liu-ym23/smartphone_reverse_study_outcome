package com.bytedance.dora.bwdl.session;

import oj4.f;
import pj4.b;

/* JADX INFO: loaded from: classes15.dex */
public final class Session {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f204378b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tj4.a f204379a;

    public static final enum DataType extends Enum<DataType> {
        public static final DataType DATA_TYPE_AUDIO = null;
        public static final DataType DATA_TYPE_FILE = null;
        public static final DataType DATA_TYPE_MESSAGE = null;
        public static final DataType DATA_TYPE_VIDEO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DataType[] f204380a = null;

        static {
            DataType r100 = new DataType("DATA_TYPE_AUDIO", 0);
            DATA_TYPE_AUDIO = r100;
            DataType r101 = new DataType("DATA_TYPE_VIDEO", 1);
            DATA_TYPE_VIDEO = r101;
            DataType r102 = new DataType("DATA_TYPE_MESSAGE", 2);
            DATA_TYPE_MESSAGE = r102;
            DataType r103 = new DataType("DATA_TYPE_FILE", 3);
            DATA_TYPE_FILE = r103;
            f204380a = new DataType[]{r100, r101, r102, r103};
        }

        public static DataType[] values() {
            return (DataType[]) f204380a.clone();
        }

        public static DataType valueOf(String r100) {
            return (DataType) r27.a.a(DataType.class, r100);
        }

        public DataType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum SessionType extends Enum<SessionType> {
        public static final SessionType SESSION_TYPE_BYTE_LINK = null;
        public static final SessionType SESSION_TYPE_GATT = null;
        public static final SessionType SESSION_TYPE_SPP = null;
        public static final SessionType SESSION_TYPE_WIFI = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SessionType[] f204381a = null;

        static {
            SessionType r100 = new SessionType("SESSION_TYPE_SPP", 0);
            SESSION_TYPE_SPP = r100;
            SessionType r101 = new SessionType("SESSION_TYPE_GATT", 1);
            SESSION_TYPE_GATT = r101;
            SessionType r102 = new SessionType("SESSION_TYPE_WIFI", 2);
            SESSION_TYPE_WIFI = r102;
            SessionType r103 = new SessionType("SESSION_TYPE_BYTE_LINK", 3);
            SESSION_TYPE_BYTE_LINK = r103;
            f204381a = new SessionType[]{r100, r101, r102, r103};
        }

        public static SessionType[] values() {
            return (SessionType[]) f204381a.clone();
        }

        public static SessionType valueOf(String r100) {
            return (SessionType) r27.a.a(SessionType.class, r100);
        }

        public SessionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SessionType f204382a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f204383b;

        public a(SessionType r100, DataType[] r101, b r102) {
            this.f204382a = r100;
            DataType[] r103 = (DataType[]) r101.clone();
            this.f204383b = r102;
        }
    }

    static {
        f204378b = new Object();
    }

    public Session(a r100) {
        SessionType r101 = r100.f204382a;
        if (r101 != SessionType.SESSION_TYPE_SPP) goto L6;
        this.f204379a = new f();
        return;
    L6:
        if (r101 != SessionType.SESSION_TYPE_GATT) goto L9;
        return;
    L9:
        if (r101 != SessionType.SESSION_TYPE_WIFI) goto L12;
        return;
    L12:
        if (r101 != SessionType.SESSION_TYPE_BYTE_LINK) goto L16;
        this.f204379a = new pj4.a();
        return;
    }

    public final void a(tj4.b r100) {
        Object r101 = f204378b;
        monitor-enter(r101);
        this.f204379a.b(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
