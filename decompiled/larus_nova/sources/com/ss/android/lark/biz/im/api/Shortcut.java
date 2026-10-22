package com.ss.android.lark.biz.im.api;

import com.ss.android.lark.chat.entity.Channel;
import java.io.Serializable;

/* JADX INFO: loaded from: classes34.dex */
public class Shortcut implements Serializable {
    private Channel channel;
    private int position;

    public static final enum Operation extends Enum<Operation> {
        public static final Operation ADD = null;
        public static final Operation DELETE = null;
        public static final Operation MODIFY = null;
        public static final Operation UNKNOWN_OPERATION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Operation[] f409895a = null;
        private int value;

        static {
            Operation r100 = new Operation("UNKNOWN_OPERATION", 0, 0);
            UNKNOWN_OPERATION = r100;
            Operation r101 = new Operation("ADD", 1, 1);
            ADD = r101;
            Operation r102 = new Operation("DELETE", 2, 2);
            DELETE = r102;
            Operation r103 = new Operation("MODIFY", 3, 3);
            MODIFY = r103;
            f409895a = new Operation[]{r100, r101, r102, r103};
        }

        public static Operation[] values() {
            return (Operation[]) f409895a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Operation forNumber(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return MODIFY;
        L14:
            return DELETE;
        L16:
            return ADD;
        L18:
            return UNKNOWN_OPERATION;
        }

        public static Operation valueOf(String r100) {
            return (Operation) r27.a.a(Operation.class, r100);
        }

        public static Operation valueOf(int r100) {
            return forNumber(r100);
        }

        public Operation(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public Channel getChannel() {
        return this.channel;
    }

    public int getPosition() {
        return this.position;
    }

    public Shortcut(Channel r100) {
        this.channel = r100;
    }

    public void setChannel(Channel r100) {
        this.channel = r100;
    }

    public void setPosition(int r100) {
        this.position = r100;
    }

    public Shortcut(int r100, String r101) {
        this.channel = new Channel(r100, r101);
    }

    public Shortcut(Channel.Type r100, String r101) {
        this.channel = new Channel(r100, r101);
    }
}
