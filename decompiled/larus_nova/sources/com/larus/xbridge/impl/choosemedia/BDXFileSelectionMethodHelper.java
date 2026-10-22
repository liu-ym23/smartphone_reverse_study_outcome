package com.larus.xbridge.impl.choosemedia;

import android.content.Context;
import android.content.Intent;
import com.ss.android.lark.utils.statistics.PerfLog;
import h4a.d;
import j4a.f;
import j4a.i;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public abstract class BDXFileSelectionMethodHelper implements f, ug9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<Context> f379825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f379826b;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/xbridge/impl/choosemedia/BDXFileSelectionMethodHelper$FeatureType;", "", "<init>", "(Ljava/lang/String;I)V", "TAKE_PHOTO", "PICK_PHOTO_FROM_ALBUM", "TAKE_VIDEO", "PICK_VIDEO_FROM_ALBUM", "PICK_PHOTO_AND_VIDEO_FROM_ALBUM", "UNSUPPORTED", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FeatureType extends Enum<FeatureType> {
        public static final a Companion = null;
        public static final FeatureType PICK_PHOTO_AND_VIDEO_FROM_ALBUM = null;
        public static final FeatureType PICK_PHOTO_FROM_ALBUM = null;
        public static final FeatureType PICK_VIDEO_FROM_ALBUM = null;
        public static final FeatureType TAKE_PHOTO = null;
        public static final FeatureType TAKE_VIDEO = null;
        public static final FeatureType UNSUPPORTED = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FeatureType[] f379827a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f379828b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<FeatureType> getEntries() {
            return f379828b;
        }

        static {
            FeatureType r100 = new FeatureType("TAKE_PHOTO", 0);
            TAKE_PHOTO = r100;
            FeatureType r101 = new FeatureType("PICK_PHOTO_FROM_ALBUM", 1);
            PICK_PHOTO_FROM_ALBUM = r101;
            FeatureType r102 = new FeatureType("TAKE_VIDEO", 2);
            TAKE_VIDEO = r102;
            FeatureType r103 = new FeatureType("PICK_VIDEO_FROM_ALBUM", 3);
            PICK_VIDEO_FROM_ALBUM = r103;
            FeatureType r104 = new FeatureType("PICK_PHOTO_AND_VIDEO_FROM_ALBUM", 4);
            PICK_PHOTO_AND_VIDEO_FROM_ALBUM = r104;
            FeatureType r105 = new FeatureType("UNSUPPORTED", 5);
            UNSUPPORTED = r105;
            FeatureType[] r110 = {r100, r101, r102, r103, r104, r105};
            f379827a = r110;
            f379828b = EnumEntriesKt.enumEntries(r110);
            Companion = new a();
        }

        public static FeatureType[] values() {
            return (FeatureType[]) f379827a.clone();
        }

        public static FeatureType valueOf(String r100) {
            return (FeatureType) r27.a.a(FeatureType.class, r100);
        }

        public FeatureType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f379829a = null;

        static {
            int[] r100 = new int[FeatureType.values().length];
            r100[FeatureType.PICK_VIDEO_FROM_ALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[FeatureType.TAKE_VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[FeatureType.TAKE_PHOTO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[FeatureType.PICK_PHOTO_FROM_ALBUM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[FeatureType.PICK_PHOTO_AND_VIDEO_FROM_ALBUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f379829a = r100;
        }
    }

    static {
    }

    public BDXFileSelectionMethodHelper(WeakReference<Context> r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f379825a = r100;
    }

    @Override // ug9.a
    public final void onActivityResult(int r100, int r101, Intent r102) {
        switch(r100) {
            case 1311210: goto L4;
            case 1311211: goto L4;
            case 1311212: goto L4;
            case 1311213: goto L4;
            case 1311214: goto L4;
            default: goto L3;
        };
    L3:
        ((d) this).onFailed(0, "Unrecognized request code");
        return;
    L4:
        i r103 = this.f379826b;
        if (r103 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("mIFileMediaFeature");
        r103 = null;
    L7:
        r103.onActivityResult(r100, r101, r102);
    }
}
