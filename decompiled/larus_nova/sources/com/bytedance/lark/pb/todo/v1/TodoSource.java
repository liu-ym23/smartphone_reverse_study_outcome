package com.bytedance.lark.pb.todo.v1;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.obric.miniapp.alarm.AlarmSessionType;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.tab.v1.space.DocTabPayload;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum TodoSource extends Enum<TodoSource> implements WireEnum {
    private static final /* synthetic */ TodoSource[] $VALUES = null;
    public static final ProtoAdapter<TodoSource> ADAPTER = null;
    public static final TodoSource CHAT = null;
    public static final TodoSource DOC = null;
    public static final TodoSource DOCX = null;
    public static final TodoSource DOC_PRODUCT = null;
    public static final TodoSource MEEGO = null;
    public static final TodoSource OAPI = null;
    public static final TodoSource TODO = null;
    public static final TodoSource UNKNOWN_SOURCE = null;
    private final int value;

    static {
        TodoSource r100 = new TodoSource("UNKNOWN_SOURCE", 0, 0);
        UNKNOWN_SOURCE = r100;
        TodoSource r101 = new TodoSource(AlarmSessionType.TODO, 1, 1);
        TODO = r101;
        TodoSource r102 = new TodoSource("CHAT", 2, 2);
        CHAT = r102;
        TodoSource r103 = new TodoSource(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 3, 3);
        DOC = r103;
        TodoSource r104 = new TodoSource("DOC_PRODUCT", 4, 4);
        DOC_PRODUCT = r104;
        TodoSource r105 = new TodoSource(DocTabPayload.VALUE_OPAI, 5, 6);
        OAPI = r105;
        TodoSource r110 = new TodoSource(PreloadConfigModel.VERSION_CHECK_TYPE_DOCX, 6, 8);
        DOCX = r110;
        TodoSource r111 = new TodoSource("MEEGO", 7, 9);
        MEEGO = r111;
        $VALUES = new TodoSource[]{r100, r101, r102, r103, r104, r105, r110, r111};
        ADAPTER = ProtoAdapter.newEnumAdapter(TodoSource.class);
    }

    public static TodoSource[] values() {
        return (TodoSource[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static TodoSource fromValue(int r100) {
        if (r100 == 0) goto L34;
        if (r100 == 1) goto L32;
        if (r100 == 2) goto L30;
        if (r100 == 3) goto L28;
        if (r100 == 4) goto L26;
        if (r100 == 6) goto L24;
        if (r100 == 8) goto L22;
        if (r100 == 9) goto L20;
        return null;
    L20:
        return MEEGO;
    L22:
        return DOCX;
    L24:
        return OAPI;
    L26:
        return DOC_PRODUCT;
    L28:
        return DOC;
    L30:
        return CHAT;
    L32:
        return TODO;
    L34:
        return UNKNOWN_SOURCE;
    }

    public static TodoSource valueOf(String r100) {
        return (TodoSource) a.a(TodoSource.class, r100);
    }

    private TodoSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
