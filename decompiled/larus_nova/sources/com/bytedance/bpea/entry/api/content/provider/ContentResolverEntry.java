package com.bytedance.bpea.entry.api.content.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.bytedance.bpea.basics.BPEAException;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.entry.common.BaseAuthEntry;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class ContentResolverEntry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f202183a = null;

    public static final class Companion {
        public Companion() {
        }

        public static String a(Uri r100) {
            String r101 = r100.getAuthority();
            if (r101 == null) goto L16;
            int r102 = r101.hashCode();
            if (r102 == (-845193793)) goto L14;
            if (r102 != (-456066902)) goto L16;
            if (r101.equals("com.android.calendar") == false) goto L16;
            return "calendar";
        L14:
            if (r101.equals("com.android.contacts") == false) goto L16;
            return "contact";
        L16:
            return "contentProvider";
        }

        @JvmStatic
        public final int delete(final ContentResolver r100, final Uri r101, final Bundle r102, Cert r103) throws BPEAException {
            return ((Number) BaseAuthEntry.f202194a.a(e.a(r103, new String[]{a(r101)}, "contentProvider_delete", 240019), new ContentResolverEntry$Companion$delete$2(r100, r101, r102))).intValue();
        }

        @JvmStatic
        public final Uri insert(final ContentResolver r100, final Uri r101, final ContentValues r102, Cert r103) throws BPEAException {
            return (Uri) BaseAuthEntry.f202194a.a(e.a(r103, new String[]{a(r101)}, "contentProvider_insert", 240017), new ContentResolverEntry$Companion$insert$1(r100, r101, r102));
        }

        @JvmStatic
        public final int delete(final ContentResolver r100, final Uri r101, final String r102, final String[] r103, Cert r104) throws BPEAException {
            return ((Number) BaseAuthEntry.f202194a.a(e.a(r104, new String[]{a(r101)}, "contentProvider_delete", 240019), new ContentResolverEntry$Companion$delete$1(r100, r101, r102, r103))).intValue();
        }

        @JvmStatic
        public final Uri insert(final ContentResolver r100, final Uri r101, final ContentValues r102, final Bundle r103, Cert r104) throws BPEAException {
            return (Uri) BaseAuthEntry.f202194a.a(e.a(r104, new String[]{a(r101)}, "contentProvider_insert", 240017), new ContentResolverEntry$Companion$insert$2(r100, r101, r102, r103));
        }

        @JvmStatic
        public final int update(final ContentResolver r100, final Uri r101, final ContentValues r102, final Bundle r103, Cert r104) throws BPEAException {
            return ((Number) BaseAuthEntry.f202194a.a(e.a(r104, new String[]{a(r101)}, "contentProvider_update", 240018), new ContentResolverEntry$Companion$update$2(r100, r101, r102, r103))).intValue();
        }

        @JvmStatic
        public final Cursor query(final ContentResolver r100, final Uri r110, final String[] r111, final Bundle r112, final CancellationSignal r113, Cert r114) throws BPEAException {
            return (Cursor) BaseAuthEntry.f202194a.a(e.a(r114, new String[]{a(r110)}, "contentProvider_query", 240004), new ContentResolverEntry$Companion$query$3(r100, r110, r111, r112, r113));
        }

        @JvmStatic
        public final int update(final ContentResolver r100, final Uri r110, final ContentValues r111, final String r112, final String[] r113, Cert r114) throws BPEAException {
            return ((Number) BaseAuthEntry.f202194a.a(e.a(r114, new String[]{a(r110)}, "contentProvider_update", 240018), new ContentResolverEntry$Companion$update$1(r100, r110, r111, r112, r113))).intValue();
        }

        @JvmStatic
        public final Cursor query(final ContentResolver r110, final Uri r111, final String[] r112, final String r113, final String[] r114, final String r115, Cert r116) throws BPEAException {
            return (Cursor) BaseAuthEntry.f202194a.a(e.a(r116, new String[]{a(r111)}, "contentProvider_query", 240004), new ContentResolverEntry$Companion$query$1(r110, r111, r112, r113, r114, r115));
        }

        @JvmStatic
        public final Cursor query(final ContentResolver r110, final Uri r111, final String[] r112, final String r113, final String[] r114, final String r115, final CancellationSignal r116, Cert r117) throws BPEAException {
            return (Cursor) BaseAuthEntry.f202194a.a(e.a(r117, new String[]{a(r111)}, "contentProvider_query", 240004), new ContentResolverEntry$Companion$query$2(r110, r111, r112, r113, r114, r115, r116));
        }
    }

    @JvmStatic
    public static final int delete(ContentResolver r100, Uri r101, Bundle r102, Cert r103) throws BPEAException {
        return f202183a.delete(r100, r101, r102, r103);
    }

    @JvmStatic
    public static final int delete(ContentResolver r100, Uri r101, String r102, String[] r103, Cert r110) throws BPEAException {
        return f202183a.delete(r100, r101, r102, r103, r110);
    }

    @JvmStatic
    public static final Uri insert(ContentResolver r100, Uri r101, ContentValues r102, Bundle r103, Cert r110) throws BPEAException {
        return f202183a.insert(r100, r101, r102, r103, r110);
    }

    @JvmStatic
    public static final Uri insert(ContentResolver r100, Uri r101, ContentValues r102, Cert r103) throws BPEAException {
        return f202183a.insert(r100, r101, r102, r103);
    }

    @JvmStatic
    public static final Cursor query(ContentResolver r100, Uri r101, String[] r102, Bundle r110, CancellationSignal r111, Cert r112) throws BPEAException {
        return f202183a.query(r100, r101, r102, r110, r111, r112);
    }

    @JvmStatic
    public static final Cursor query(ContentResolver r100, Uri r110, String[] r111, String r112, String[] r113, String r114, CancellationSignal r115, Cert r116) throws BPEAException {
        return f202183a.query(r100, r110, r111, r112, r113, r114, r115, r116);
    }

    @JvmStatic
    public static final Cursor query(ContentResolver r100, Uri r101, String[] r110, String r111, String[] r112, String r113, Cert r114) throws BPEAException {
        return f202183a.query(r100, r101, r110, r111, r112, r113, r114);
    }

    @JvmStatic
    public static final int update(ContentResolver r100, Uri r101, ContentValues r102, Bundle r103, Cert r110) throws BPEAException {
        return f202183a.update(r100, r101, r102, r103, r110);
    }

    @JvmStatic
    public static final int update(ContentResolver r100, Uri r101, ContentValues r102, String r110, String[] r111, Cert r112) throws BPEAException {
        return f202183a.update(r100, r101, r102, r110, r111, r112);
    }

    static {
        f202183a = new Companion();
    }
}
