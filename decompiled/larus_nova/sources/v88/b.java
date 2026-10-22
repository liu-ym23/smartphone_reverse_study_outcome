package v88;

/* JADX INFO: loaded from: classes23.dex */
public final class b {
    public static final String a(int r100) {
        switch(r100) {
            case 0: goto L14;
            case 1: goto L13;
            case 2: goto L12;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L16;
            case 10: goto L5;
            case 11: goto L16;
            case 12: goto L4;
            default: goto L16;
        };
    L4:
        return "WakeQuery.INTERACTIVE_PULL_REQUEST";
    L5:
        return "WakeQuery.REJECT_START_VUI";
    L6:
        return "WakeQuery.STOP_CONVERSATION";
    L7:
        return "WakeQuery.START_CONVERSATION";
    L8:
        return "WakeQuery.LIVE_AI_UNMUTE";
    L9:
        return "WakeQuery.LIVE_AI_MUTE";
    L10:
        return "WakeQuery.TTS_BREAK";
    L11:
        return "WakeQuery.END";
    L12:
        return "WakeQuery.START";
    L13:
        return "WakeQuery.STOP";
    L14:
        return "WakeQuery.INVALID";
    L16:
        return "WakeQuery Undefined: " + r100;
    }
}
