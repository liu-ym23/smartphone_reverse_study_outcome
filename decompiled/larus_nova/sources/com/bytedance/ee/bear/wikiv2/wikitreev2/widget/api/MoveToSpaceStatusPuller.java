package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: classes18.dex */
public final class MoveToSpaceStatusPuller extends b<Params, Result> {

    public static final enum MoveToSpaceStatus extends Enum<MoveToSpaceStatus> {
        public static final MoveToSpaceStatus MOVE_DONE = null;
        public static final MoveToSpaceStatus MOVE_FAILED = null;
        public static final MoveToSpaceStatus MOVING = null;
        public static final MoveToSpaceStatus UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MoveToSpaceStatus[] f241686a = null;
        private final int status;

        static {
            MoveToSpaceStatus r100 = new MoveToSpaceStatus("MOVING", 0, 1);
            MOVING = r100;
            MoveToSpaceStatus r101 = new MoveToSpaceStatus("MOVE_DONE", 1, 2);
            MOVE_DONE = r101;
            MoveToSpaceStatus r102 = new MoveToSpaceStatus("MOVE_FAILED", 2, 3);
            MOVE_FAILED = r102;
            MoveToSpaceStatus r103 = new MoveToSpaceStatus("UNKNOWN", 3, -1);
            UNKNOWN = r103;
            f241686a = new MoveToSpaceStatus[]{r100, r101, r102, r103};
        }

        public static MoveToSpaceStatus[] values() {
            return (MoveToSpaceStatus[]) f241686a.clone();
        }

        public int getStatus() {
            return this.status;
        }

        public static MoveToSpaceStatus valueOf(String r100) {
            return (MoveToSpaceStatus) r27.a.a(MoveToSpaceStatus.class, r100);
        }

        public MoveToSpaceStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.status = r102;
        }
    }

    public static class Params implements NonProguard {
        public String task_id;

        public String toString() {
            return "Params{task_id='" + yu5.c.j(this.task_id) + "'}";
        }

        public Params(String r100) {
            this.task_id = r100;
        }
    }

    public static class Result implements NonProguard {
        public String obj_token;
        public int obj_type;
        public int status;
        public String task_id;
        public String url;

        public Result() {
        }

        public String toString() {
            return "Result{task_id=" + this.task_id + ", status=" + this.status + ", obj_type=" + this.obj_type + ", obj_token=" + yu5.c.j(this.obj_token) + ", url=" + yu5.c.j(this.url) + '}';
        }
    }

    public MoveToSpaceStatusPuller(NetService r100) {
        super(r100, "/space/api/wiki/v2/tree/move_to_space_status/", 2, 1);
    }
}
