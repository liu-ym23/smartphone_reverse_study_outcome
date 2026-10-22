package com.ss.android.lark.create.groupchat.impl.service;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import com.ss.android.lark.create.groupchat.dto.CreateGroupMode;
import com.ss.android.lark.doc.entity.DocPermPair;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f420198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<PickChatEntity> f420199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f420200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Map<String, DocPermPair.PermType>> f420201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f420202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f420203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f420204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f420205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f420206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f420207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f420208k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Chat.ChatMode f420209l;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f420210a = null;

        static {
            int[] r100 = new int[CreateGroupMode.values().length];
            r100[CreateGroupMode.CONVERSATION_MODE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[CreateGroupMode.TOPIC_MODE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[CreateGroupMode.SECRET_MODE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f420210a = r100;
        }
    }

    public d() {
        this.f420198a = new ArrayList();
        this.f420199b = new LinkedHashSet();
        this.f420200c = new ArrayList();
        this.f420201d = new LinkedHashMap();
        this.f420202e = "";
        this.f420203f = "";
        this.f420204g = "";
        this.f420209l = Chat.ChatMode.DEFAULT;
    }
}
