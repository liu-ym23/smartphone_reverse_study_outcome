package com.relax.relaxframework;

import com.byted.cast.common.TeaEventTrack;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/relax/relaxframework/InputConfirmType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Done", "Send", "Search", "Go", "Next", "relax-framework_release"}, k = 1, mv = {1, 7, 1})
public final enum InputConfirmType extends Enum<InputConfirmType> {
    public static final InputConfirmType Done = null;
    public static final InputConfirmType Go = null;
    public static final InputConfirmType Next = null;
    public static final InputConfirmType Search = null;
    public static final InputConfirmType Send = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InputConfirmType[] f404743a = null;
    private final String value;

    public static InputConfirmType valueOf(String r100) {
        return (InputConfirmType) r27.a.a(InputConfirmType.class, r100);
    }

    public static InputConfirmType[] values() {
        return (InputConfirmType[]) f404743a.clone();
    }

    static {
        InputConfirmType r100 = new InputConfirmType("Done", 0, "done");
        Done = r100;
        InputConfirmType r101 = new InputConfirmType("Send", 1, "send");
        Send = r101;
        InputConfirmType r102 = new InputConfirmType("Search", 2, "search");
        Search = r102;
        InputConfirmType r103 = new InputConfirmType("Go", 3, "go");
        Go = r103;
        InputConfirmType r104 = new InputConfirmType("Next", 4, TeaEventTrack.ACTION_DRAMA_NEXT);
        Next = r104;
        f404743a = new InputConfirmType[]{r100, r101, r102, r103, r104};
    }

    public final String getValue() {
        return this.value;
    }

    public InputConfirmType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
