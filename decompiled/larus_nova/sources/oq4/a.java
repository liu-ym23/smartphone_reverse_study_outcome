package oq4;

import android.text.TextUtils;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableDataModel;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.AutoNumberModel;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.DateModel;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.GroupList;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.Location;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.NumberModel;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.ReferenceModel;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.SegmentModel;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.UserList;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.AttachmentEntity;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.PhoneInfo;
import com.bytedance.ee.bear.bitable.card.view.cell.formgrid.FormGridCellData;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;
import java.lang.reflect.Type;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements ExtraProcessor, ExtraTypeProvider {

    /* JADX INFO: renamed from: oq4.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C7092a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f524878a = null;

        static {
            int[] r100 = new int[EFieldType.values().length];
            f524878a = r100;
            r100[EFieldType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L80:
            f524878a[EFieldType.URL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L58:
            f524878a[EFieldType.NUMBER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L74:
            f524878a[EFieldType.SINGLE_SELECT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L82:
            f524878a[EFieldType.MULTI_SELECT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L60:
            f524878a[EFieldType.STAGE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
        L66:
            f524878a[EFieldType.DATE_TIME.ordinal()] = 7;     // Catch: NoSuchFieldError -> L33
        L94:
            f524878a[EFieldType.CHECKBOX.ordinal()] = 8;     // Catch: NoSuchFieldError -> L34
        L52:
            f524878a[EFieldType.USER.ordinal()] = 9;     // Catch: NoSuchFieldError -> L35
        L86:
            f524878a[EFieldType.CREATED_USER.ordinal()] = 10;     // Catch: NoSuchFieldError -> L36
        L90:
            f524878a[EFieldType.MODIFIED_USER.ordinal()] = 11;     // Catch: NoSuchFieldError -> L37
        L70:
            f524878a[EFieldType.GROUP.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
        L78:
            f524878a[EFieldType.ATTACHMENT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L39
        L56:
            f524878a[EFieldType.SINGLE_LINK.ordinal()] = 14;     // Catch: NoSuchFieldError -> L40
        L64:
            f524878a[EFieldType.DUPLEX_LINK.ordinal()] = 15;     // Catch: NoSuchFieldError -> L41
        L92:
            f524878a[EFieldType.FORMULA.ordinal()] = 16;     // Catch: NoSuchFieldError -> L42
        L50:
            f524878a[EFieldType.LOOKUP.ordinal()] = 17;     // Catch: NoSuchFieldError -> L43
        L84:
            f524878a[EFieldType.CREATED_TIME.ordinal()] = 18;     // Catch: NoSuchFieldError -> L44
        L88:
            f524878a[EFieldType.MODIFIED_TIME.ordinal()] = 19;     // Catch: NoSuchFieldError -> L45
        L68:
            f524878a[EFieldType.AUTO_NUMBER.ordinal()] = 20;     // Catch: NoSuchFieldError -> L46
        L76:
            f524878a[EFieldType.PHONE.ordinal()] = 21;     // Catch: NoSuchFieldError -> L47
        L54:
            f524878a[EFieldType.LOCATION.ordinal()] = 22;     // Catch: NoSuchFieldError -> L48
        L62:
            f524878a[EFieldType.FORM_GRID.ordinal()] = 23;     // Catch: NoSuchFieldError -> L49
            return;
        }
    }

    public static class b extends TypeReference<List<AttachmentEntity>> {
        public b(int r100) {
        }
    }

    public static class c extends TypeReference<List<AutoNumberModel>> {
        public c(int r100) {
        }
    }

    public static class d extends TypeReference<List<Boolean>> {
        public d(int r100) {
        }
    }

    public static class e extends TypeReference<List<DateModel>> {
        public e(int r100) {
        }
    }

    public static class f extends TypeReference<FormGridCellData> {
        public f(int r100) {
        }
    }

    public static class g extends TypeReference<List<GroupList>> {
        public g(int r100) {
        }
    }

    public static class h extends TypeReference<List<Location>> {
        public h(int r100) {
        }
    }

    public static class i extends TypeReference<List<Long>> {
        public i(int r100) {
        }
    }

    public static class j extends TypeReference<List<NumberModel>> {
        public j(int r100) {
        }
    }

    public static class k extends TypeReference<List<PhoneInfo>> {
        public k(int r100) {
        }
    }

    public static class l extends TypeReference<List<TableDataModel.RecordsBean>> {
        public l(int r100) {
        }
    }

    public static class m extends TypeReference<List<ReferenceModel>> {
        public m(int r100) {
        }
    }

    public static class n extends TypeReference<List<SegmentModel>> {
        public n(int r100) {
        }
    }

    public static class o extends TypeReference<List<String>> {
        public o(int r100) {
        }
    }

    public static class p extends TypeReference<List<UserList>> {
        public p(int r100) {
        }
    }

    public a() {
    }

    public static Type a(EFieldType r100) {
        switch(C7092a.f524878a[r100.ordinal()]) {
            case 1: goto L35;
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L31;
            case 5: goto L31;
            case 6: goto L31;
            case 7: goto L29;
            case 8: goto L27;
            case 9: goto L25;
            case 10: goto L25;
            case 11: goto L25;
            case 12: goto L23;
            case 13: goto L21;
            case 14: goto L19;
            case 15: goto L19;
            case 16: goto L17;
            case 17: goto L17;
            case 18: goto L15;
            case 19: goto L15;
            case 20: goto L13;
            case 21: goto L11;
            case 22: goto L9;
            case 23: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return new f(0).getType();
    L9:
        return new h(0).getType();
    L11:
        return new k(0).getType();
    L13:
        return new c(0).getType();
    L15:
        return new i(0).getType();
    L17:
        return new m(0).getType();
    L19:
        return new l(0).getType();
    L21:
        return new b(0).getType();
    L23:
        return new g(0).getType();
    L25:
        return new p(0).getType();
    L27:
        return new d(0).getType();
    L29:
        return new e(0).getType();
    L31:
        return new o(0).getType();
    L33:
        return new j(0).getType();
    L35:
        return new n(0).getType();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider
    public final Type getExtraType(Object r100, String r101) {
        if ((r100 instanceof TableDataModel.RecordsBean.ContentBean) == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L10;
        return null;
    L10:
        return a(((TableDataModel.RecordsBean.ContentBean) r100).type);
    L5:
        if (TextUtils.equals(r101, "value") == false) goto L7;
        r102 = true;
        goto L8
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ExtraProcessor
    public final void processExtra(Object r100, String r101, Object r102) {
        if ((r100 instanceof TableDataModel.RecordsBean.ContentBean) == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L11;
        ((TableDataModel.RecordsBean.ContentBean) r100).fieldValue = r102;
        return;
    L11:
        return;
    L5:
        if (TextUtils.equals(r101, "value") == false) goto L7;
        r103 = true;
        goto L8
    }
}
