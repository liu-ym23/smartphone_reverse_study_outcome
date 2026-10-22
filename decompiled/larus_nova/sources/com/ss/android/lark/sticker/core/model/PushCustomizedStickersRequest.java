package com.ss.android.lark.sticker.core.model;

import d6c.b;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final class PushCustomizedStickersRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Operation f440831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<com.ss.android.lark.chat.entity.sticker.Sticker> f440832b;

    public static final enum Operation extends Enum<Operation> {
        public static final Operation ADD = null;
        public static final Operation DELETE = null;
        public static final Operation MODIFY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Operation[] f440833a = null;
        private int mValue;

        static {
            Operation r100 = new Operation("ADD", 0, 1);
            ADD = r100;
            Operation r101 = new Operation("DELETE", 1, 2);
            DELETE = r101;
            Operation r102 = new Operation("MODIFY", 2, 3);
            MODIFY = r102;
            f440833a = new Operation[]{r100, r101, r102};
        }

        public static Operation[] values() {
            return (Operation[]) f440833a.clone();
        }

        public int getNumber() {
            return this.mValue;
        }

        public static Operation forNumber(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 2) goto L13;
            if (r100 == 3) goto L11;
            return null;
        L11:
            return MODIFY;
        L13:
            return DELETE;
        L15:
            return ADD;
        }

        public static Operation valueOf(String r100) {
            return (Operation) a.a(Operation.class, r100);
        }

        public static Operation valueOf(int r100) {
            return forNumber(r100);
        }

        public Operation(String r100, int r101, int r102) {
            super(r100, r101);
            this.mValue = r102;
        }
    }

    public PushCustomizedStickersRequest(com.bytedance.lark.pb.im.v1.PushCustomizedStickersRequest r100) {
        this.f440831a = Operation.forNumber(r100.operation.getValue());
        this.f440832b = b.b(r100.stickers);
        r100.update_time.longValue();
    }
}
