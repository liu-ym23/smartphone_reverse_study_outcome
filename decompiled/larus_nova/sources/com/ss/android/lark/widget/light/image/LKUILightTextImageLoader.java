package com.ss.android.lark.widget.light.image;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.widget.span.v;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
public final class LKUILightTextImageLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Object> f446066a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Object> f446067b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f446068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f446069d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f446070e = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/widget/light/image/LKUILightTextImageLoader$LoadType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "NET", "DISK_CACHE", "MEMORY_CACHE", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoadType extends Enum<LoadType> {
        public static final LoadType DISK_CACHE = null;
        public static final LoadType MEMORY_CACHE = null;
        public static final LoadType NET = null;
        public static final LoadType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadType[] f446071a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f446072b = null;
        private final int value;

        public static EnumEntries<LoadType> getEntries() {
            return f446072b;
        }

        static {
            LoadType r100 = new LoadType("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            LoadType r101 = new LoadType("NET", 1, 1);
            NET = r101;
            LoadType r102 = new LoadType("DISK_CACHE", 2, 2);
            DISK_CACHE = r102;
            LoadType r103 = new LoadType("MEMORY_CACHE", 3, 3);
            MEMORY_CACHE = r103;
            LoadType[] r104 = {r100, r101, r102, r103};
            f446071a = r104;
            f446072b = EnumEntriesKt.enumEntries(r104);
        }

        public static LoadType[] values() {
            return (LoadType[]) f446071a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static LoadType valueOf(String r100) {
            return (LoadType) r27.a.a(LoadType.class, r100);
        }

        public LoadType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f446073a = null;

        static {
            int[] r100 = new int[DataSource.values().length];
            r100[DataSource.REMOTE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[DataSource.LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[DataSource.DATA_DISK_CACHE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[DataSource.RESOURCE_DISK_CACHE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[DataSource.MEMORY_CACHE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f446073a = r100;
        }
    }

    public LKUILightTextImageLoader() {
    }

    static {
        f446066a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("resource_content_length", -1)});
        f446067b = MapsKt.mapOf(new Pair[]{TuplesKt.to("from_type", 2), TuplesKt.to("image_type", LoadParams.ImageFormat.JPEG), TuplesKt.to("chat_type", 0), TuplesKt.to(ChameleonOpenTracker.ParamKey.LOAD_TYPE, 1), TuplesKt.to("color_space", "SRGB")});
        f446068c = "";
        f446069d = LazyKt.lazy(LKUILightTextImageLoader$sEncryptImageFetcher$2.INSTANCE);
        f446070e = LazyKt.lazy(LKUILightTextImageLoader$sLocalImageFetcher$2.INSTANCE);
    }

    public static v.a b() {
        return (v.a) f446069d.getValue();
    }

    public static v.a d() {
        return (v.a) f446070e.getValue();
    }

    public static LoadType c(DataSource r100) {
        if (r100 != null) goto L5;
        int r101 = -1;
    L6:
        if (r101 == (-1)) goto L23;
        if (r101 == 1) goto L26;
        if (r101 == 2) goto L25;
        if (r101 == 3) goto L25;
        if (r101 == 4) goto L25;
        if (r101 != 5) goto L19;
        return LoadType.MEMORY_CACHE;
    L19:
        throw new NoWhenBranchMatchedException();
    L25:
        return LoadType.DISK_CACHE;
    L26:
        return LoadType.NET;
    L23:
        return LoadType.UNKNOWN;
    L5:
        r101 = a.f446073a[r100.ordinal()];
        goto L6
    }

    public static final HashMap a(Object r100, EncryptImage r101, boolean r102, String r103) {
        HashMap r104 = new HashMap();
        if (r101 == null) goto L5;
        long r105 = r101.getResourceSize();
    L7:
        if (r105 == 0) goto L9;
    L13:
        r104.put("resource_content_length", Long.valueOf(r105));
        if (r102 == true) goto L16;
    L19:
        if (r101 == null) goto L22;
        String r106 = r101.getEncryptKey();
        if (r106 == null) goto L22;
    L23:
        r104.put("image_key", r106);
        return r104;
    L22:
        r106 = "other scene";
        goto L23
    L16:
        if (TextUtils.isEmpty(r103) == true) goto L19;
        if (r103 == null) goto L19;
        r104.put(MusicAppletPage.KEY_MESSAGE_ID, r103);
        r104.put("is_message_delete", Boolean.FALSE);
        goto L19
    L9:
        if ((r100 instanceof BitmapDrawable) == false) goto L13;
        Bitmap r107 = ((BitmapDrawable) r100).getBitmap();
        if (r107 == null) goto L13;
        r105 = r107.getWidth() * r107.getHeight();
        goto L13
    L5:
        r105 = 0;
        goto L7
    }
}
