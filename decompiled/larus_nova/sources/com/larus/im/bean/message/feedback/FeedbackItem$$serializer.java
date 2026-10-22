package com.larus.im.bean.message.feedback;

import com.obric.capabilitykit.EntityProvider;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.List;
import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.UnknownFieldException;
import kuc.a;
import luc.f;
import muc.c;
import muc.e;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes29.dex */
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class FeedbackItem$$serializer implements m0<FeedbackItem> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FeedbackItem$$serializer f347120a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g2 f347121b = null;

    public FeedbackItem$$serializer() {
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return f347121b;
    }

    static {
        FeedbackItem$$serializer r100 = new FeedbackItem$$serializer();
        f347120a = r100;
        g2 r101 = new g2("com.larus.im.bean.message.feedback.FeedbackItem", r100, 8);
        r101.j("feedbackType", true);
        final String[] r102 = {"feedback_type", "feedbackType"};
        r101.k(new FeedbackItem$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(r102));
        r101.j("feedbackDetailType", true);
        final String[] r103 = {"feedback_detail_type", "feedbackDetailType"};
        r101.k(new FeedbackItem$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(r103));
        r101.j("feedbackDetailTypes", true);
        final String[] r104 = {"feedback_detail_types", "feedbackDetailTypes"};
        r101.k(new FeedbackItem$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(r104));
        r101.j("feedbackDetailContent", true);
        final String[] r105 = {"feedback_detail_content", "feedbackDetailContent"};
        r101.k(new FeedbackItem$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(r105));
        r101.j("scene", true);
        r101.j("entityID", true);
        final String[] r106 = {PickerReporterConstants.KEY.ENTITY_ID, "entityID"};
        r101.k(new FeedbackItem$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(r106));
        r101.j("entityType", true);
        final String[] r107 = {EntityProvider.KEY_ENTITY_TYPE, "entityType"};
        r101.k(new FeedbackItem$$serializer$annotationImpl$kotlinx_serialization_json_JsonNames$0(r107));
        r101.j("extra", true);
        f347121b = r101;
    }

    @Override // nuc.m0
    public final d<?>[] childSerializers() {
        Lazy<d<Object>>[] r100 = FeedbackItem.f347111i;
        w0 r101 = w0.f520792a;
        v2 r102 = v2.f520790a;
        return new d[]{r101, a.d(r101), a.d(r100[2].getValue()), a.d(r102), a.d(r102), a.d(r102), a.d(r102), a.d(r102)};
    }

    @Override // nuc.m0
    public final d<?>[] typeParametersSerializers() {
        return i2.f520710a;
    }

    @Override // juc.c
    public final Object deserialize(e r210) {
        Intrinsics.checkNotNullParameter(r210, "decoder");
        g2 r100 = f347121b;
        c r101 = r210.beginStructure(r100);
        Lazy<d<Object>>[] r102 = FeedbackItem.f347111i;
        int r103 = 3;
        int r104 = 6;
        int r105 = 7;
        int r106 = 4;
        if (r101.decodeSequentially() == false) goto L5;
        int r107 = r101.decodeIntElement(r100, 0);
        Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 1, w0.f520792a, null);
        List r109 = (List) r101.decodeNullableSerializableElement(r100, 2, r102[2].getValue(), null);
        v2 r110 = v2.f520790a;
        String r111 = (String) r101.decodeNullableSerializableElement(r100, 3, r110, null);
        String r112 = (String) r101.decodeNullableSerializableElement(r100, 4, r110, null);
        String r113 = (String) r101.decodeNullableSerializableElement(r100, 5, r110, null);
        List r114 = r109;
        String r115 = r111;
        String r116 = (String) r101.decodeNullableSerializableElement(r100, 6, r110, null);
        String r117 = (String) r101.decodeNullableSerializableElement(r100, 7, r110, null);
        String r118 = r112;
        Integer r119 = r108;
        String r120 = r113;
        int r121 = 255;
        int r122 = r107;
    L26:
        r101.endStructure(r100);
        return new FeedbackItem(r121, r122, r119, r114, r115, r118, r120, r116, r117);
    L5:
        String r123 = null;
        String r124 = null;
        String r125 = null;
        String r126 = null;
        r120 = null;
        List r127 = null;
        Integer r128 = null;
        int r129 = 0;
        int r130 = 0;
        boolean r131 = true;
    L6:
        if (r131 == false) goto L25;
        int r132 = r101.decodeElementIndex(r100);
        switch(r132) {
            case -1: goto L24;
            case 0: goto L22;
            case 1: goto L21;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L10;
        };
    L10:
        throw new UnknownFieldException(r132);
    L24:
        r103 = 3;
        r104 = 6;
        r105 = 7;
        r106 = 4;
        r131 = false;
        goto L6
    L11:
        r125 = (String) r101.decodeNullableSerializableElement(r100, r105, v2.f520790a, r125);
        int r133 = r130 | 128;
    L14:
        r130 = r133;
        List r134 = r127;
    L23:
        r127 = r134;
        r103 = 3;
        r104 = 6;
        r105 = 7;
        r106 = 4;
        goto L6
    L12:
        r126 = (String) r101.decodeNullableSerializableElement(r100, r104, v2.f520790a, r126);
        r133 = r130 | 64;
        goto L14
    L13:
        r120 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r120);
        r133 = r130 | 32;
        goto L14
    L15:
        r124 = (String) r101.decodeNullableSerializableElement(r100, r106, v2.f520790a, r124);
        int r135 = r130 | 16;
    L17:
        int r136 = r135;
    L19:
        r130 = r136;
        r134 = r127;
        goto L23
    L16:
        r123 = (String) r101.decodeNullableSerializableElement(r100, r103, v2.f520790a, r123);
        r135 = r130 | 8;
        goto L17
    L18:
        r127 = (List) r101.decodeNullableSerializableElement(r100, 2, r102[2].getValue(), r127);
        r136 = r130 | 4;
        goto L19
    L21:
        r134 = r127;
        r128 = (Integer) r101.decodeNullableSerializableElement(r100, 1, w0.f520792a, r128);
        r130 = r130 | 2;
        goto L23
    L22:
        r134 = r127;
        r129 = r101.decodeIntElement(r100, 0);
        r130 = r130 | 1;
        goto L23
    L25:
        List r137 = r127;
        r119 = r128;
        r117 = r125;
        r116 = r126;
        r115 = r123;
        r118 = r124;
        r121 = r130;
        r122 = r129;
        r114 = r137;
        goto L26
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        FeedbackItem r102 = (FeedbackItem) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        g2 r103 = f347121b;
        muc.d r104 = r100.beginStructure(r103);
        Lazy<d<Object>>[] r105 = FeedbackItem.f347111i;
        boolean r106 = false;
        if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
    L7:
        boolean r107 = true;
    L9:
        if (r107 == false) goto L12;
        r104.encodeIntElement(r103, 0, r102.f347112a);
    L12:
        if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
    L16:
        boolean r108 = true;
    L18:
        if (r108 == false) goto L21;
        r104.encodeNullableSerializableElement(r103, 1, w0.f520792a, r102.f347113b);
    L21:
        if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
    L25:
        boolean r109 = true;
    L27:
        if (r109 == false) goto L30;
        r104.encodeNullableSerializableElement(r103, 2, r105[2].getValue(), r102.f347114c);
    L30:
        if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
    L34:
        boolean r110 = true;
    L36:
        if (r110 == false) goto L39;
        r104.encodeNullableSerializableElement(r103, 3, v2.f520790a, r102.f347115d);
    L39:
        if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
    L43:
        boolean r111 = true;
    L45:
        if (r111 == false) goto L48;
        r104.encodeNullableSerializableElement(r103, 4, v2.f520790a, r102.f347116e);
    L48:
        if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
    L52:
        boolean r112 = true;
    L54:
        if (r112 == false) goto L57;
        r104.encodeNullableSerializableElement(r103, 5, v2.f520790a, r102.f347117f);
    L57:
        if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
    L61:
        boolean r113 = true;
    L63:
        if (r113 == false) goto L66;
        r104.encodeNullableSerializableElement(r103, 6, v2.f520790a, r102.f347118g);
    L66:
        if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L69;
    L70:
        r106 = true;
    L71:
        if (r106 == false) goto L73;
        r104.encodeNullableSerializableElement(r103, 7, v2.f520790a, r102.f347119h);
    L73:
        r104.endStructure(r103);
        return;
    L69:
        if (r102.f347119h == null) goto L71;
    L60:
        if (r102.f347118g != null) goto L61;
        r113 = false;
        goto L63
    L51:
        if (r102.f347117f != null) goto L52;
        r112 = false;
        goto L54
    L42:
        if (r102.f347116e != null) goto L43;
        r111 = false;
        goto L45
    L33:
        if (r102.f347115d != null) goto L34;
        r110 = false;
        goto L36
    L24:
        if (r102.f347114c != null) goto L25;
        r109 = false;
        goto L27
    L15:
        if (r102.f347113b != null) goto L16;
        r108 = false;
        goto L18
    L6:
        if (r102.f347112a != 0) goto L7;
        r107 = false;
        goto L9
    }
}
