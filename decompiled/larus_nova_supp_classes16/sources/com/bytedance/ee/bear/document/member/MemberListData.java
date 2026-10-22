package com.bytedance.ee.bear.document.member;

import com.bytedance.ee.util.io.NonProguardWithoutSerializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/document/member/MemberListData;", "Lcom/bytedance/ee/util/io/NonProguardWithoutSerializable;", "<init>", "()V", "data", "", "Lcom/bytedance/ee/bear/document/member/MemberListData$MemberData;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "checkValid", "", "MemberData", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MemberListData implements NonProguardWithoutSerializable {
    private List<MemberData> data;
    private String title;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/document/member/MemberListData$MemberData;", "Lcom/bytedance/ee/util/io/NonProguardWithoutSerializable;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "avatarUrl", "getAvatarUrl", "setAvatarUrl", "name", "getName", "setName", "department", "getDepartment", "setDepartment", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MemberData implements NonProguardWithoutSerializable {
        private String avatarUrl;
        private String department;
        private String id;
        private String name;

        public MemberData() {
            this.id = "";
            this.avatarUrl = "";
            this.name = "";
        }

        public final String getAvatarUrl() {
            return this.avatarUrl;
        }

        public final String getDepartment() {
            return this.department;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final void setAvatarUrl(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.avatarUrl = r2;
        }

        public final void setDepartment(String r1) {
            this.department = r1;
        }

        public final void setId(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.id = r2;
        }

        public final void setName(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.name = r2;
        }
    }

    public final boolean checkValid() {
        if (this.data == null) goto L5;
        return true;
    L5:
        return false;
    }

    public MemberListData() {
        this.title = "";
    }

    public final List<MemberData> getData() {
        return this.data;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setData(List<MemberData> r1) {
        this.data = r1;
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }
}
