package com.bytedance.ee.bear.list.dto;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/list/dto/DocVersion;", "Lcom/bytedance/ee/util/io/NonProguard;", "ownerType", "", "<init>", "(I)V", "getOwnerType", "()I", "nil", "", "getNil", "()Z", "setNil", "(Z)V", "isDocV2", "Companion", "contentmanager-space-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocVersion implements NonProguard {
    public static final a Companion = null;
    public static final int OWNER_TYPE_DOCUMENT_V1 = 0;
    public static final int OWNER_TYPE_DOCUMENT_V2 = 5;
    private boolean nil;
    private final int ownerType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DocVersion() {
        int r100 = 0;
        this(r100, 1, null);
    }

    @JvmStatic
    public static final int getOwnerType(boolean r100) {
        Companion.getClass();
        if (r100 == false) goto L5;
        return 5;
    L5:
        return 0;
    }

    @JvmStatic
    public static final boolean isDocV2(int r100) {
        Companion.getClass();
        if (r100 != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isDocV2() {
        if (this.ownerType != 5) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getNil() {
        return this.nil;
    }

    public final int getOwnerType() {
        return this.ownerType;
    }

    public DocVersion(int r100) {
        this.ownerType = r100;
    }

    public final void setNil(boolean r100) {
        this.nil = r100;
    }

    public /* synthetic */ DocVersion(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 5;
    L5:
        this(r100);
    }
}
