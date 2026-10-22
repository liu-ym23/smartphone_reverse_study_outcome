package com.bytedance.ee.bear.wikiv2.home.api;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0010\u001a\u00020\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home/api/DisplayTag;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "tag_value", "", "getTag_value", "()Ljava/lang/String;", "setTag_value", "(Ljava/lang/String;)V", "tag_type", "", "getTag_type", "()I", "setTag_type", "(I)V", "isValidInSameTenant", "", "Companion", "contentmanager-wiki-api_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DisplayTag implements NonProguard {
    public static final a Companion = null;
    public static final int ENTERPRISE_PUBLIC = 5;
    public static final int INTERNAL_PUBLIC = 1;
    private int tag_type;
    private String tag_value;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DisplayTag() {
    }

    public final boolean isValidInSameTenant() {
        int r0 = this.tag_type;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 == 5) goto L10;
        return false;
    L10:
        return true;
    }

    public final int getTag_type() {
        return this.tag_type;
    }

    public final String getTag_value() {
        return this.tag_value;
    }

    public final void setTag_type(int r1) {
        this.tag_type = r1;
    }

    public final void setTag_value(String r1) {
        this.tag_value = r1;
    }
}
