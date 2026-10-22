package com.bytedance.bdp.serviceapi.defaults.image;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/bdp/serviceapi/defaults/image/AlbumMode;", "", "", "value", "I", "getValue", "()I", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CHOICE_DEFAULT", "CHOICE_ORIGIN", "CHOICE_OPTIONAL", "CHOICE_COMPRESS", "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
public final enum AlbumMode extends Enum<AlbumMode> {
    public static final AlbumMode CHOICE_COMPRESS = null;
    public static final AlbumMode CHOICE_DEFAULT = null;
    public static final AlbumMode CHOICE_OPTIONAL = null;
    public static final AlbumMode CHOICE_ORIGIN = null;
    public static final a Companion = null;
    public static final String KEY = "album_mode";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AlbumMode[] f201552a = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    static {
        AlbumMode r100 = new AlbumMode("CHOICE_DEFAULT", 0, -1);
        CHOICE_DEFAULT = r100;
        AlbumMode r101 = new AlbumMode("CHOICE_ORIGIN", 1, 0);
        CHOICE_ORIGIN = r101;
        AlbumMode r102 = new AlbumMode("CHOICE_OPTIONAL", 2, 1);
        CHOICE_OPTIONAL = r102;
        AlbumMode r103 = new AlbumMode("CHOICE_COMPRESS", 3, 2);
        CHOICE_COMPRESS = r103;
        f201552a = new AlbumMode[]{r100, r101, r102, r103};
        Companion = new a();
    }

    public static AlbumMode valueOf(String r100) {
        return (AlbumMode) r27.a.a(AlbumMode.class, r100);
    }

    public static AlbumMode[] values() {
        return (AlbumMode[]) f201552a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final AlbumMode valueOf(int r100) {
        Companion.getClass();
        AlbumMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        AlbumMode r104 = r101[r103];
        if (r104.getValue() != r100) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L15;
        r103 = r103 + 1;
        goto L3
    L15:
        return r104;
    L7:
        r105 = false;
        goto L8
    L11:
        return null;
    }

    public AlbumMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
