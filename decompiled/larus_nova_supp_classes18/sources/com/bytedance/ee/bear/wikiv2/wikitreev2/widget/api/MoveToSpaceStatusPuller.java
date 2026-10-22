package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.util.io.NonProguard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class MoveToSpaceStatusPuller extends b<Params, Result> {

    public static final enum MoveToSpaceStatus extends Enum<MoveToSpaceStatus> {
        public static final MoveToSpaceStatus MOVE_DONE = null;
        public static final MoveToSpaceStatus MOVE_FAILED = null;
        public static final MoveToSpaceStatus MOVING = null;
        public static final MoveToSpaceStatus UNKNOWN = null;
        public static final /* synthetic */ MoveToSpaceStatus[] a = null;
        private final int status;

        static {
            MoveToSpaceStatus r0 = new MoveToSpaceStatus("MOVING", 0, 1);
            MOVING = r0;
            MoveToSpaceStatus r1 = new MoveToSpaceStatus("MOVE_DONE", 1, 2);
            MOVE_DONE = r1;
            MoveToSpaceStatus r4 = new MoveToSpaceStatus("MOVE_FAILED", 2, 3);
            MOVE_FAILED = r4;
            MoveToSpaceStatus r6 = new MoveToSpaceStatus("UNKNOWN", 3, -1);
            UNKNOWN = r6;
            a = new MoveToSpaceStatus[]{r0, r1, r4, r6};
        }

        public static MoveToSpaceStatus[] values() {
            return (MoveToSpaceStatus[]) a.clone();
        }

        public int getStatus() {
            return this.status;
        }

        public static MoveToSpaceStatus valueOf(String r1) {
            return (MoveToSpaceStatus) r27.a.a(MoveToSpaceStatus.class, r1);
        }

        public MoveToSpaceStatus(String r1, int r2, int r3) {
            super(r1, r2);
            this.status = r3;
        }
    }

    public static class Params implements NonProguard {
        public String task_id;

        public String toString() {
            return "Params{task_id='" + yu5.c.j(this.task_id) + "'}";
        }

        public Params(String r1) {
            this.task_id = r1;
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

    public MoveToSpaceStatusPuller(NetService r4) {
        super(r4, "/space/api/wiki/v2/tree/move_to_space_status/", 2, 1);
    }
}
