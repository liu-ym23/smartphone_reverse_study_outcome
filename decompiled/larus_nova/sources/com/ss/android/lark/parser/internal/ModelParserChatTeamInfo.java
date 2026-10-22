package com.ss.android.lark.parser.internal;

import com.ss.android.lark.chat.entity.chat.ChatTeamInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes37.dex */
public final class ModelParserChatTeamInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ModelParserChatTeamInfo f437609a = null;

    static {
        f437609a = new ModelParserChatTeamInfo();
    }

    public ModelParserChatTeamInfo() {
    }

    @JvmStatic
    public static final List<ChatTeamInfo> a(List<com.bytedance.lark.pb.basic.v1.ChatTeamInfo> r100) {
        if (r100 == null) goto L9;
        ModelParserChatTeamInfo$parseChatTeamInfoList$1 r101 = new ModelParserChatTeamInfo$parseChatTeamInfoList$1(f437609a);
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L5:
        if (r103.hasNext() == false) goto L16;
        ChatTeamInfo r104 = r101.invoke(r103.next());
        if (r104 == null) goto L5;
        r102.add(r104);
        goto L5
    L16:
        return r102;
    L9:
        return null;
    }
}
