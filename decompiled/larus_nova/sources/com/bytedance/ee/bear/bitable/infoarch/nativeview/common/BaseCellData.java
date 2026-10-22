package com.bytedance.ee.bear.bitable.infoarch.nativeview.common;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.widgets.HighlightModel;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.FieldUIKitFactory;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.a0;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.b0;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.c;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.c0;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.d;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.d0;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.e;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.f;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.g;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.i;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.j;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.k;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.l;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.m;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.n;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.o;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.p;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.q;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.r;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.s;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.t;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.u;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.v;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.w;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.x;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.y;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.z;
import com.bytedance.ee.util.io.NonProguard;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 92\u00020\u0001:\u00019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u00106\u001a\u00020\u0017J\b\u00107\u001a\u000208H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001e\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u0010\n\u0002\u0010-\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R.\u0010.\u001a\u0016\u0012\u0004\u0012\u000200\u0018\u00010/j\n\u0012\u0004\u0012\u000200\u0018\u0001`1X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006:"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseCellData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "fieldId", "", "getFieldId", "()Ljava/lang/String;", "setFieldId", "(Ljava/lang/String;)V", "fieldName", "getFieldName", "setFieldName", "highlightColor", "getHighlightColor", "setHighlightColor", "highlightColorV2", "Lcom/bytedance/ee/bear/bitable/common/widgets/HighlightModel;", "getHighlightColorV2", "()Lcom/bytedance/ee/bear/bitable/common/widgets/HighlightModel;", "setHighlightColorV2", "(Lcom/bytedance/ee/bear/bitable/common/widgets/HighlightModel;)V", "isBold", "", "()Ljava/lang/Boolean;", "setBold", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "borderHighlightColor", "getBorderHighlightColor", "setBorderHighlightColor", "fieldUIType", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "getFieldUIType", "()Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "setFieldUIType", "(Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;)V", "isClipped", "setClipped", "totalChildCount", "", "getTotalChildCount", "()Ljava/lang/Integer;", "setTotalChildCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "data", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IFiledUIkitModel;", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "isEmptyValue", "getType", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/FieldUIKitFactory$Type;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseCellData implements NonProguard {
    public static final a Companion = null;
    private String borderHighlightColor;
    private ArrayList<h0> data;
    private String fieldId;
    private String fieldName;
    private EFieldUIType fieldUIType;
    private String highlightColor;
    private HighlightModel highlightColorV2;
    private Boolean isBold;
    private Boolean isClipped;
    private Integer totalChildCount;

    public static final class a {
        public a() {
        }

        public static Type a(EFieldUIType r100) {
            Intrinsics.checkNotNullParameter(r100, "fieldUIType");
            c r101 = FieldUIKitFactory.f216138a;
            FieldUIKitFactory.a(FieldUIKitFactory.Type.COMMON);
            Intrinsics.checkNotNullParameter(r100, "fieldUIType");
            switch(c.a.f216163a[r100.ordinal()]) {
                case 1: goto L32;
                case 2: goto L59;
                case 3: goto L58;
                case 4: goto L57;
                case 5: goto L56;
                case 6: goto L55;
                case 7: goto L54;
                case 8: goto L53;
                case 9: goto L52;
                case 10: goto L51;
                case 11: goto L50;
                case 12: goto L49;
                case 13: goto L48;
                case 14: goto L47;
                case 15: goto L46;
                case 16: goto L45;
                case 17: goto L44;
                case 18: goto L43;
                case 19: goto L42;
                case 20: goto L41;
                case 21: goto L40;
                case 22: goto L39;
                case 23: goto L38;
                case 24: goto L37;
                case 25: goto L36;
                case 26: goto L35;
                case 27: goto L34;
                default: goto L4;
            };
        L4:
            return null;
        L34:
            return new v().getType();
        L35:
            return new u().getType();
        L36:
            return new t().getType();
        L37:
            return new s().getType();
        L38:
            return new r().getType();
        L39:
            return new q().getType();
        L40:
            return new p().getType();
        L41:
            return new o().getType();
        L42:
            return new m().getType();
        L43:
            return new l().getType();
        L44:
            return new k().getType();
        L45:
            return new j().getType();
        L46:
            return new i().getType();
        L47:
            return new h().getType();
        L48:
            return new g().getType();
        L49:
            return new f().getType();
        L50:
            return new e().getType();
        L51:
            return new d().getType();
        L52:
            return new d0().getType();
        L53:
            return new c0().getType();
        L54:
            return new b0().getType();
        L55:
            return new a0().getType();
        L56:
            return new z().getType();
        L57:
            return new y().getType();
        L58:
            return new x().getType();
        L59:
            return new w().getType();
        L32:
            return new n().getType();
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isEmptyValue() {
        ArrayList<h0> r100 = this.data;
        boolean r101 = true;
        if (r100 == null) goto L8;
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        h0 r103 = (h0) r102.next();
        r101 = (r101 & (r103 instanceof h0)) & r103.isEmptyValue();
    L8:
        return r101;
    }

    public BaseCellData() {
        this.fieldId = "";
        this.fieldName = "";
        this.isBold = Boolean.FALSE;
        this.fieldUIType = EFieldUIType.NOT_SUPPORT;
    }

    public final String getBorderHighlightColor() {
        return this.borderHighlightColor;
    }

    public final ArrayList<h0> getData() {
        return this.data;
    }

    public final String getFieldId() {
        return this.fieldId;
    }

    public final String getFieldName() {
        return this.fieldName;
    }

    public final EFieldUIType getFieldUIType() {
        return this.fieldUIType;
    }

    public final String getHighlightColor() {
        return this.highlightColor;
    }

    public final HighlightModel getHighlightColorV2() {
        return this.highlightColorV2;
    }

    public final Integer getTotalChildCount() {
        return this.totalChildCount;
    }

    public FieldUIKitFactory.Type getType() {
        return FieldUIKitFactory.Type.COMMON;
    }

    public final Boolean isBold() {
        return this.isBold;
    }

    public final Boolean isClipped() {
        return this.isClipped;
    }

    public final void setBold(Boolean r100) {
        this.isBold = r100;
    }

    public final void setBorderHighlightColor(String r100) {
        this.borderHighlightColor = r100;
    }

    public final void setClipped(Boolean r100) {
        this.isClipped = r100;
    }

    public final void setData(ArrayList<h0> r100) {
        this.data = r100;
    }

    public final void setFieldId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fieldId = r100;
    }

    public final void setFieldName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fieldName = r100;
    }

    public final void setFieldUIType(EFieldUIType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fieldUIType = r100;
    }

    public final void setHighlightColor(String r100) {
        this.highlightColor = r100;
    }

    public final void setHighlightColorV2(HighlightModel r100) {
        this.highlightColorV2 = r100;
    }

    public final void setTotalChildCount(Integer r100) {
        this.totalChildCount = r100;
    }
}
