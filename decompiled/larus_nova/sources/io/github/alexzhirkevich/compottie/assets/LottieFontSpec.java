package io.github.alexzhirkevich.compottie.assets;

import androidx.compose.ui.text.font.FontWeight;
import com.amap.api.services.cloud.CloudSearch;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final class LottieFontSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f490726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FontWeight f490727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f490728c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lio/github/alexzhirkevich/compottie/assets/LottieFontSpec$FontOrigin;", "", "<init>", "(Ljava/lang/String;I)V", CloudSearch.SearchBound.LOCAL_SHAPE, "CssUrl", "ScriptUrl", "FontUrl", "Unknown", "compottie_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FontOrigin extends Enum<FontOrigin> {
        public static final FontOrigin CssUrl = null;
        public static final FontOrigin FontUrl = null;
        public static final FontOrigin Local = null;
        public static final FontOrigin ScriptUrl = null;
        public static final FontOrigin Unknown = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FontOrigin[] f490729a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f490730b = null;

        public static EnumEntries<FontOrigin> getEntries() {
            return f490730b;
        }

        static {
            FontOrigin r100 = new FontOrigin(CloudSearch.SearchBound.LOCAL_SHAPE, 0);
            Local = r100;
            FontOrigin r101 = new FontOrigin("CssUrl", 1);
            CssUrl = r101;
            FontOrigin r102 = new FontOrigin("ScriptUrl", 2);
            ScriptUrl = r102;
            FontOrigin r103 = new FontOrigin("FontUrl", 3);
            FontUrl = r103;
            FontOrigin r104 = new FontOrigin("Unknown", 4);
            Unknown = r104;
            FontOrigin[] r105 = {r100, r101, r102, r103, r104};
            f490729a = r105;
            f490730b = EnumEntriesKt.enumEntries(r105);
        }

        public static FontOrigin[] values() {
            return (FontOrigin[]) f490729a.clone();
        }

        public static FontOrigin valueOf(String r100) {
            return (FontOrigin) a.a(FontOrigin.class, r100);
        }

        public FontOrigin(String r100, int r101) {
            super(r100, r101);
        }
    }

    public LottieFontSpec(String r100, String r101, int r102, FontWeight r103, FontOrigin r104, float r105) {
        Intrinsics.checkNotNullParameter(r100, "family");
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r103, "weight");
        Intrinsics.checkNotNullParameter(r104, PlayerResolution.SDKKEY.ORIGIN);
        this.f490726a = r102;
        this.f490727b = r103;
        this.f490728c = r105;
    }
}
