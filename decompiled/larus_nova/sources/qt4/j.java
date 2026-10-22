package qt4;

import com.bytedance.ee.bear.bitable.itemview.cell.cellview.AttachmentCellValue;
import com.bytedance.ee.bear.bitable.itemview.cell.cellview.ButtonCellValue;
import com.bytedance.ee.bear.bitable.itemview.cell.cellview.CheckboxCellValue;
import com.bytedance.ee.bear.bitable.itemview.cell.cellview.DateTimeCellValue;
import com.bytedance.ee.bear.bitable.itemview.cell.cellview.FormatterTextCellValue;
import com.bytedance.ee.bear.bitable.itemview.cell.cellview.GroupCellValue;
import com.bytedance.ee.bear.bitable.itemview.cell.cellview.ProgressCellValue;
import com.bytedance.ee.bear.bitable.itemview.cell.cellview.RatingCellValue;
import com.bytedance.ee.bear.bitable.itemview.cell.cellview.RichTextCellValue;
import com.bytedance.ee.bear.bitable.itemview.cell.cellview.SelectCellValue;
import com.bytedance.ee.bear.bitable.itemview.cell.cellview.UserCellValue;
import com.bytedance.ee.bear.bitable.itemview.cell.link.LinkTableCellValue;
import com.bytedance.ee.bear.bitable.itemview.cell.link.LinkTagCellValue;
import com.bytedance.ee.bear.bitable.itemview.cell.stage.StageCellValue;
import com.bytedance.ee.bear.bitable.itemview.cell.stage.StageTabItemCellData;
import com.bytedance.ee.bear.bitable.itemview.record.list.CellPureUIType;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class j {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f534814a = null;

        static {
            int[] r100 = new int[CellPureUIType.values().length];
            r100[CellPureUIType.RichText.ordinal()] = 1;     // Catch: NoSuchFieldError -> L24
        L67:
            r100[CellPureUIType.FormatterText.ordinal()] = 2;     // Catch: NoSuchFieldError -> L25
        L79:
            r100[CellPureUIType.Location.ordinal()] = 3;     // Catch: NoSuchFieldError -> L26
        L49:
            r100[CellPureUIType.Select.ordinal()] = 4;     // Catch: NoSuchFieldError -> L27
        L53:
            r100[CellPureUIType.User.ordinal()] = 5;     // Catch: NoSuchFieldError -> L28
        L61:
            r100[CellPureUIType.Group.ordinal()] = 6;     // Catch: NoSuchFieldError -> L29
        L73:
            r100[CellPureUIType.Attachment_Preview.ordinal()] = 7;     // Catch: NoSuchFieldError -> L30
        L57:
            r100[CellPureUIType.Attachment_Preview_Big.ordinal()] = 8;     // Catch: NoSuchFieldError -> L31
        L69:
            r100[CellPureUIType.Signature.ordinal()] = 9;     // Catch: NoSuchFieldError -> L32
        L71:
            r100[CellPureUIType.DateTime.ordinal()] = 10;     // Catch: NoSuchFieldError -> L33
        L45:
            r100[CellPureUIType.LinkTagCompact.ordinal()] = 11;     // Catch: NoSuchFieldError -> L34
        L65:
            r100[CellPureUIType.LinkTagAll.ordinal()] = 12;     // Catch: NoSuchFieldError -> L35
        L77:
            r100[CellPureUIType.LinkTable.ordinal()] = 13;     // Catch: NoSuchFieldError -> L36
        L43:
            r100[CellPureUIType.Checkbox.ordinal()] = 14;     // Catch: NoSuchFieldError -> L37
        L55:
            r100[CellPureUIType.Button.ordinal()] = 15;     // Catch: NoSuchFieldError -> L38
        L75:
            r100[CellPureUIType.Progress.ordinal()] = 16;     // Catch: NoSuchFieldError -> L39
        L47:
            r100[CellPureUIType.Rating.ordinal()] = 17;     // Catch: NoSuchFieldError -> L40
        L51:
            r100[CellPureUIType.StageTag.ordinal()] = 18;     // Catch: NoSuchFieldError -> L41
        L63:
            r100[CellPureUIType.StageView.ordinal()] = 19;     // Catch: NoSuchFieldError -> L42
        L22:
            f534814a = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$10", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/DateTimeCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b extends TypeToken<DateTimeCellValue> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$11", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTagCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TypeToken<LinkTagCellValue> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$12", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTagCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d extends TypeToken<LinkTagCellValue> {
        public d() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$13", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/link/LinkTableCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e extends TypeToken<LinkTableCellValue> {
        public e() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$14", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/CheckboxCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f extends TypeToken<CheckboxCellValue> {
        public f() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$15", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/ButtonCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g extends TypeToken<ButtonCellValue> {
        public g() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$16", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/ProgressCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h extends TypeToken<ProgressCellValue> {
        public h() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$17", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/RatingCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i extends TypeToken<RatingCellValue> {
        public i() {
        }
    }

    /* JADX INFO: renamed from: qt4.j$j, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$18", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C7390j extends TypeToken<StageCellValue> {
        public C7390j() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$19", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageTabItemCellData;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class k extends TypeToken<StageTabItemCellData> {
        public k() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/RichTextCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class l extends TypeToken<RichTextCellValue> {
        public l() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$2", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/FormatterTextCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class m extends TypeToken<FormatterTextCellValue> {
        public m() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$3", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/FormatterTextCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class n extends TypeToken<FormatterTextCellValue> {
        public n() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$4", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/SelectCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class o extends TypeToken<SelectCellValue> {
        public o() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$5", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/UserCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class p extends TypeToken<UserCellValue> {
        public p() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$6", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/GroupCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class q extends TypeToken<GroupCellValue> {
        public q() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$7", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/AttachmentCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class r extends TypeToken<AttachmentCellValue> {
        public r() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$8", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/AttachmentCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class s extends TypeToken<AttachmentCellValue> {
        public s() {
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/bytedance/ee/bear/bitable/itemview/cell/ItemViewCellParserKt$getCellValueType$9", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/AttachmentCellValue;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class t extends TypeToken<AttachmentCellValue> {
        public t() {
        }
    }

    public static final Type a(CellPureUIType r100) {
        Intrinsics.checkNotNullParameter(r100, "cellPureUIType");
        switch(a.f534814a[r100.ordinal()]) {
            case 1: goto L24;
            case 2: goto L43;
            case 3: goto L42;
            case 4: goto L41;
            case 5: goto L40;
            case 6: goto L39;
            case 7: goto L38;
            case 8: goto L37;
            case 9: goto L36;
            case 10: goto L35;
            case 11: goto L34;
            case 12: goto L33;
            case 13: goto L32;
            case 14: goto L31;
            case 15: goto L30;
            case 16: goto L29;
            case 17: goto L28;
            case 18: goto L27;
            case 19: goto L26;
            default: goto L4;
        };
    L4:
        return null;
    L26:
        return new k().getType();
    L27:
        return new C7390j().getType();
    L28:
        return new i().getType();
    L29:
        return new h().getType();
    L30:
        return new g().getType();
    L31:
        return new f().getType();
    L32:
        return new e().getType();
    L33:
        return new d().getType();
    L34:
        return new c().getType();
    L35:
        return new b().getType();
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
        return new n().getType();
    L43:
        return new m().getType();
    L24:
        return new l().getType();
    }
}
