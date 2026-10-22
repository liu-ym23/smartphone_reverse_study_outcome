package com.bytedance.awemeopen.apps.framework.comment.api.constants;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/api/constants/CommentColorMode;", "", "MODE_LIGHT", "MODE_DARK", "MODE_LIGHT_OR_DARK", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final enum CommentColorMode extends Enum<CommentColorMode> {
    public static final CommentColorMode MODE_DARK = null;
    public static final CommentColorMode MODE_LIGHT = null;
    public static final CommentColorMode MODE_LIGHT_OR_DARK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommentColorMode[] f194109a = null;

    public static CommentColorMode valueOf(String r100) {
        return (CommentColorMode) a.a(CommentColorMode.class, r100);
    }

    public static CommentColorMode[] values() {
        return (CommentColorMode[]) f194109a.clone();
    }

    static {
        CommentColorMode r100 = new CommentColorMode("MODE_LIGHT", 0);
        MODE_LIGHT = r100;
        CommentColorMode r101 = new CommentColorMode("MODE_DARK", 1);
        MODE_DARK = r101;
        CommentColorMode r102 = new CommentColorMode("MODE_LIGHT_OR_DARK", 2);
        MODE_LIGHT_OR_DARK = r102;
        f194109a = new CommentColorMode[]{r100, r101, r102};
    }

    public CommentColorMode(String r100, int r101) {
        super(r100, r101);
    }
}
