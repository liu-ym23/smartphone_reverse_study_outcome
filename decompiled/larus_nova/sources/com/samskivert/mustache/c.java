package com.samskivert.mustache;

import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.lark.widget.span.InlineCodeInfo;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f405726a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f405727b = null;

    public static class a implements e.h {
        public a() {
        }

        @Override // com.samskivert.mustache.e.h
        public final String a(String r100) {
            return r100;
        }
    }

    static {
        f405726a = new d(new String[][]{new String[]{"&", "&amp;"}, new String[]{"'", "&#39;"}, new String[]{"\"", "&quot;"}, new String[]{"<", "&lt;"}, new String[]{">", "&gt;"}, new String[]{InlineCodeInfo.INLINE_CODE_EDGE_PLACEHOLDER, "&#x60;"}, new String[]{ContainerUtils.KEY_VALUE_DELIMITER, "&#x3D;"}});
        f405727b = new a();
    }
}
