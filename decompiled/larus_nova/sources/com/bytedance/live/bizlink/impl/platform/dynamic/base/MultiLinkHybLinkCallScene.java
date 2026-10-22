package com.bytedance.live.bizlink.impl.platform.dynamic.base;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/live/bizlink/impl/platform/dynamic/base/MultiLinkHybLinkCallScene;", "", "", "callSceneType", "Ljava/lang/String;", "getCallSceneType", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "NotDefine", "LinkControl", "MediaControl", "GuestLinkControl", "multi-biz-link-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum MultiLinkHybLinkCallScene extends Enum<MultiLinkHybLinkCallScene> {
    public static final a Companion = null;
    public static final MultiLinkHybLinkCallScene GuestLinkControl = null;
    public static final MultiLinkHybLinkCallScene LinkControl = null;
    public static final MultiLinkHybLinkCallScene MediaControl = null;
    public static final MultiLinkHybLinkCallScene NotDefine = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiLinkHybLinkCallScene[] f254888a = null;
    private final String callSceneType;

    public static final class a {
        public a() {
        }

        public static MultiLinkHybLinkCallScene a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "callSceneStr");
            MultiLinkHybLinkCallScene[] r101 = MultiLinkHybLinkCallScene.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            MultiLinkHybLinkCallScene r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getCallSceneType(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return MultiLinkHybLinkCallScene.NotDefine;
        L8:
            r104 = null;
            goto L9
        }
    }

    static {
        MultiLinkHybLinkCallScene r100 = new MultiLinkHybLinkCallScene("NotDefine", 0, "not_define");
        NotDefine = r100;
        MultiLinkHybLinkCallScene r101 = new MultiLinkHybLinkCallScene("LinkControl", 1, "main_link_call");
        LinkControl = r101;
        MultiLinkHybLinkCallScene r102 = new MultiLinkHybLinkCallScene("MediaControl", 2, "media_call");
        MediaControl = r102;
        MultiLinkHybLinkCallScene r103 = new MultiLinkHybLinkCallScene("GuestLinkControl", 3, "guest_link_call");
        GuestLinkControl = r103;
        f254888a = new MultiLinkHybLinkCallScene[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static MultiLinkHybLinkCallScene valueOf(String r100) {
        return (MultiLinkHybLinkCallScene) r27.a.a(MultiLinkHybLinkCallScene.class, r100);
    }

    public static MultiLinkHybLinkCallScene[] values() {
        return (MultiLinkHybLinkCallScene[]) f254888a.clone();
    }

    public final String getCallSceneType() {
        return this.callSceneType;
    }

    public MultiLinkHybLinkCallScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.callSceneType = r102;
    }
}
