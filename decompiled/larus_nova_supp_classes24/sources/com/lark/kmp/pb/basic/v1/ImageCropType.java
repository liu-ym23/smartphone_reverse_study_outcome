package com.lark.kmp.pb.basic.v1;

import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00112\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/ImageCropType;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "ORIGIN", "MIDDLE", "THUMB", "MIDDLE_WEBP", "THUMB_WEBP", "MIDDLE_MP4", "COVER", "INTACT", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum ImageCropType extends Enum<ImageCropType> implements o0 {
    public static final ProtoAdapter<ImageCropType> ADAPTER = null;
    public static final ImageCropType COVER = null;
    public static final b Companion = null;
    public static final ImageCropType INTACT = null;
    public static final ImageCropType MIDDLE = null;
    public static final ImageCropType MIDDLE_MP4 = null;
    public static final ImageCropType MIDDLE_WEBP = null;
    public static final ImageCropType ORIGIN = null;
    public static final ImageCropType THUMB = null;
    public static final ImageCropType THUMB_WEBP = null;
    public static final /* synthetic */ ImageCropType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static ImageCropType a(int r0) {
            switch(r0) {
                case 1: goto L12;
                case 2: goto L20;
                case 3: goto L19;
                case 4: goto L18;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L15;
                case 8: goto L14;
                default: goto L3;
            };
        L3:
            return null;
        L14:
            return ImageCropType.INTACT;
        L15:
            return ImageCropType.COVER;
        L16:
            return ImageCropType.MIDDLE_MP4;
        L17:
            return ImageCropType.THUMB_WEBP;
        L18:
            return ImageCropType.MIDDLE_WEBP;
        L19:
            return ImageCropType.THUMB;
        L20:
            return ImageCropType.MIDDLE;
        L12:
            return ImageCropType.ORIGIN;
        }
    }

    @JvmStatic
    public static final ImageCropType fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<ImageCropType> getEntries() {
        return b;
    }

    static {
        ImageCropType r0 = new ImageCropType("ORIGIN", 0, 1);
        ORIGIN = r0;
        ImageCropType r1 = new ImageCropType("MIDDLE", 1, 2);
        MIDDLE = r1;
        ImageCropType r4 = new ImageCropType("THUMB", 2, 3);
        THUMB = r4;
        ImageCropType r6 = new ImageCropType("MIDDLE_WEBP", 3, 4);
        MIDDLE_WEBP = r6;
        ImageCropType r8 = new ImageCropType("THUMB_WEBP", 4, 5);
        THUMB_WEBP = r8;
        ImageCropType r10 = new ImageCropType("MIDDLE_MP4", 5, 6);
        MIDDLE_MP4 = r10;
        ImageCropType r12 = new ImageCropType("COVER", 6, 7);
        COVER = r12;
        ImageCropType r14 = new ImageCropType("INTACT", 7, 8);
        INTACT = r14;
        ImageCropType[] r11 = {r0, r1, r4, r6, r8, r10, r12, r14};
        a = r11;
        b = EnumEntriesKt.enumEntries(r11);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(ImageCropType.class);
        final Syntax r3 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r3);
    }

    public static ImageCropType[] values() {
        return (ImageCropType[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static ImageCropType valueOf(String r1) {
        return (ImageCropType) r27.a.a(ImageCropType.class, r1);
    }

    public ImageCropType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
