package com.bytedance.platform.aio.channel;

import com.bytedance.platform.aio.channel.js.model.BytesContentType;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public abstract class e<T> {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f266577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f266578b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f266579c;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3 */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public final int hashCode() {
            String r100 = this.f266577a;
            if (r100 == null) goto L5;
            int r101 = r100.hashCode();
        L6:
            int r102 = r101 * 31;
            boolean r103 = this.f266578b;
            ?? r104 = 1;
            ?? r105 = r103;
            if (r103 == false) goto L9;
            r105 = 1;
        L9:
            int r106 = (r102 + r105) * 31;
            boolean r107 = this.f266579c;
            if (r107 == true) goto L14;
            r104 = r107;
        L14:
            return r106 + r104;
        L5:
            r101 = 0;
            goto L6
        }

        public final String toString() {
            return "CloseChannel(channelId=" + this.f266577a + ", closeRead=" + this.f266578b + ", closeWrite=" + this.f266579c + ")";
        }

        @Override // com.bytedance.platform.aio.channel.e
        public final String a() {
            return this.f266577a;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f266577a, r101.f266577a) == true) goto L8;
            return false;
        L8:
            if (this.f266578b == r101.f266578b) goto L10;
            return false;
        L10:
            if (this.f266579c == r101.f266579c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public a(String r100, boolean r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.CHANNEL_ID);
            this.f266577a = r100;
            this.f266578b = r101;
            this.f266579c = r102;
        }

        public /* synthetic */ a(String r100, boolean r101, boolean r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = false;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = false;
        L8:
            this(r100, r101, r102);
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f266580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f266581b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f266582c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final BytesContentType f266583d;

        public final int hashCode() {
            String r100 = this.f266580a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.f266581b;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f266582c;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            BytesContentType r110 = this.f266583d;
            if (r110 == null) goto L18;
            r101 = r110.hashCode();
        L18:
            return r109 + r101;
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "CreateChannel(channelId=" + this.f266580a + ", interfaceId=" + this.f266581b + ", methodId=" + this.f266582c + ", preferredContentType=" + this.f266583d + ")";
        }

        @Override // com.bytedance.platform.aio.channel.e
        public final String a() {
            return this.f266580a;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L14;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f266580a, r101.f266580a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f266581b, r101.f266581b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f266582c, r101.f266582c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f266583d, r101.f266583d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public b(String r100, String r101, String r102, BytesContentType r103) {
            Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.CHANNEL_ID);
            Intrinsics.checkNotNullParameter(r101, "interfaceId");
            Intrinsics.checkNotNullParameter(r102, "methodId");
            Intrinsics.checkNotNullParameter(r103, "preferredContentType");
            this.f266580a = r100;
            this.f266581b = r101;
            this.f266582c = r102;
            this.f266583d = r103;
        }
    }

    public static final class c extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f266584a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f266584a, ((c) r100).f266584a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f266584a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "RegisterService(interfaceId=" + this.f266584a + ")";
        }

        @Override // com.bytedance.platform.aio.channel.e
        public final String a() {
            throw new UnsupportedOperationException();
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "interfaceId");
            this.f266584a = r100;
        }
    }

    public static abstract class d<T> extends e<T> {

        public static final class a<T> extends d<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f266585a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final T f266586b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final BytesContentType f266587c;

            public final int hashCode() {
                String r100 = this.f266585a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                T r104 = this.f266586b;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                BytesContentType r107 = this.f266587c;
                if (r107 == null) goto L14;
                r101 = r107.hashCode();
            L14:
                return r106 + r101;
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Data(channelId=" + this.f266585a + ", data=" + this.f266586b + ", contentType=" + this.f266587c + ")";
            }

            @Override // com.bytedance.platform.aio.channel.e
            public final String a() {
                return this.f266585a;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof a) == false) goto L12;
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f266585a, r101.f266585a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f266586b, r101.f266586b) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.f266587c, r101.f266587c) == true) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public a(String r100, T r101, BytesContentType r102) {
                Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.CHANNEL_ID);
                Intrinsics.checkNotNullParameter(r102, "contentType");
                this.f266585a = r100;
                this.f266586b = r101;
                this.f266587c = r102;
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f266588a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final com.bytedance.platform.aio.channel.a f266589b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final BytesContentType f266590c;

            public final int hashCode() {
                String r100 = this.f266588a;
                int r101 = 0;
                if (r100 == null) goto L5;
                int r102 = r100.hashCode();
            L6:
                int r103 = r102 * 31;
                com.bytedance.platform.aio.channel.a r104 = this.f266589b;
                if (r104 == null) goto L9;
                int r105 = r104.hashCode();
            L10:
                int r106 = (r103 + r105) * 31;
                BytesContentType r107 = this.f266590c;
                if (r107 == null) goto L14;
                r101 = r107.hashCode();
            L14:
                return r106 + r101;
            L9:
                r105 = 0;
                goto L10
            L5:
                r102 = 0;
                goto L6
            }

            public final String toString() {
                return "Error(channelId=" + this.f266588a + ", error=" + this.f266589b + ", contentType=" + this.f266590c + ")";
            }

            @Override // com.bytedance.platform.aio.channel.e
            public final String a() {
                return this.f266588a;
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L4;
                return true;
            L4:
                if ((r100 instanceof b) == false) goto L12;
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f266588a, r101.f266588a) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.f266589b, r101.f266589b) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.f266590c, r101.f266590c) == true) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public b(String r100, com.bytedance.platform.aio.channel.a r101, BytesContentType r102) {
                Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.CHANNEL_ID);
                Intrinsics.checkNotNullParameter(r101, "error");
                Intrinsics.checkNotNullParameter(r102, "contentType");
                this.f266588a = r100;
                this.f266589b = r101;
                this.f266590c = r102;
            }
        }

        public d() {
        }
    }

    public e() {
    }

    public abstract String a();
}
