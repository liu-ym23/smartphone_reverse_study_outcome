package tb2;

import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.PieceType;
import com.bytedance.android.live.base.model.message.b5;
import com.bytedance.android.live.base.model.message.c5;
import com.bytedance.android.live.base.model.message.e5;
import com.bytedance.android.live.base.model.message.f5;
import com.bytedance.android.live.base.model.message.g5;
import com.bytedance.android.live.base.model.message.i5;
import com.bytedance.android.live.base.model.message.m6;
import com.bytedance.android.live.base.model.user.h0;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class c implements c5 {
    public static final a Companion = null;
    public static final String DEFAULT_TEXT = "  ";
    public static final String IMAGE_DEFAULT_TEXT = "* ";
    private h0 badge;
    private List<c> bindUserBadgePieceList;
    private b clickAction;
    private m6 convertedSchema;
    private Integer imageDefaultRes;
    private boolean isBadgePiece;
    private String text;
    private int textIndex;

    /* JADX INFO: renamed from: tp, reason: collision with root package name */
    private c5 f545241tp;
    private int verticalOffset;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public b5 getFormat() {
        c5 r100 = this.f545241tp;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getFormat();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public e5 getGiftValue() {
        c5 r100 = this.f545241tp;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getGiftValue();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public f5 getHeartValue() {
        c5 r100 = this.f545241tp;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getHeartValue();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public ITextPieceImage getImageValue() {
        c5 r100 = this.f545241tp;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getImageValue();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public g5 getPatternRefValue() {
        c5 r100 = this.f545241tp;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPatternRefValue();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public String getRefKey() {
        c5 r100 = this.f545241tp;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRefKey();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public String getSchemaKey() {
        c5 r100 = this.f545241tp;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSchemaKey();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public String getStringValue() {
        c5 r100 = this.f545241tp;
        if (r100 == null) goto L6;
        String r101 = r100.getStringValue();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    @Override // com.bytedance.android.live.base.model.message.c5, com.bytedance.android.live.base.model.message.d5
    public int getType() {
        c5 r100 = this.f545241tp;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getType();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public i5 getUserValue() {
        c5 r100 = this.f545241tp;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getUserValue();
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public boolean isNormalPiece() {
        c5 r100 = this.f545241tp;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isNormalPiece();
    }

    public String toString() {
        return "RenderPiece(textIndex=" + this.textIndex + ", text='" + getText() + "', super = " + super.toString() + ')';
    }

    public final String getText() {
        if (getType() != PieceType.IMAGE.getPieceType()) goto L9;
        if (StringsKt.isBlank(this.text) == false) goto L9;
        return IMAGE_DEFAULT_TEXT;
    L9:
        return this.text;
    }

    public final h0 getBadge() {
        return this.badge;
    }

    public final List<c> getBindUserBadgePieceList() {
        return this.bindUserBadgePieceList;
    }

    public final b getClickAction() {
        return this.clickAction;
    }

    public final m6 getConvertedSchema() {
        return this.convertedSchema;
    }

    public final Integer getImageDefaultRes() {
        return this.imageDefaultRes;
    }

    public final int getTextIndex() {
        return this.textIndex;
    }

    public final c5 getTp() {
        return this.f545241tp;
    }

    public final int getVerticalOffset() {
        return this.verticalOffset;
    }

    public final boolean isBadgePiece() {
        return this.isBadgePiece;
    }

    public c(c5 r100) {
        this.textIndex = -1;
        this.text = DEFAULT_TEXT;
        this.f545241tp = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.c5, vh7.c
    public <R extends vh7.e<c5>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        throw new UnsupportedOperationException();
    }

    @Override // com.bytedance.android.live.base.model.message.c5, vh7.c
    public <R extends vh7.e<c5>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        throw new UnsupportedOperationException();
    }

    public final void setBadge(h0 r100) {
        this.badge = r100;
    }

    public final void setBadgePiece(boolean r100) {
        this.isBadgePiece = r100;
    }

    public final void setBindUserBadgePieceList(List<c> r100) {
        this.bindUserBadgePieceList = r100;
    }

    public final c setClickAction(b r100) {
        this.clickAction = r100;
        return this;
    }

    public final void setConvertedSchema(m6 r100) {
        this.convertedSchema = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setFormat(b5 r100) {
        c5 r101 = this.f545241tp;
        if (r101 == null) goto L6;
        r101.setFormat(r100);
        return;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setGiftValue(e5 r100) {
        c5 r101 = this.f545241tp;
        if (r101 == null) goto L6;
        r101.setGiftValue(r100);
        return;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setHeartValue(f5 r100) {
        c5 r101 = this.f545241tp;
        if (r101 == null) goto L6;
        r101.setHeartValue(r100);
        return;
    }

    public final void setImageDefaultRes(Integer r100) {
        this.imageDefaultRes = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setImageValue(ITextPieceImage r100) {
        c5 r101 = this.f545241tp;
        if (r101 == null) goto L6;
        r101.setImageValue(r100);
        return;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setNormalPiece(boolean r100) {
        c5 r101 = this.f545241tp;
        if (r101 == null) goto L6;
        r101.setNormalPiece(r100);
        return;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setPatternRefValue(g5 r100) {
        c5 r101 = this.f545241tp;
        if (r101 == null) goto L6;
        r101.setPatternRefValue(r100);
        return;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setRefKey(String r100) {
        c5 r101 = this.f545241tp;
        if (r101 == null) goto L6;
        r101.setRefKey(r100);
        return;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setSchemaKey(String r100) {
        c5 r101 = this.f545241tp;
        if (r101 == null) goto L6;
        r101.setSchemaKey(r100);
        return;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setStringValue(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        c5 r101 = this.f545241tp;
        if (r101 == null) goto L6;
        r101.setStringValue(r100);
        return;
    }

    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }

    public final void setTextIndex(int r100) {
        this.textIndex = r100;
    }

    public final void setTp(c5 r100) {
        this.f545241tp = r100;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setType(int r100) {
        c5 r101 = this.f545241tp;
        if (r101 == null) goto L6;
        r101.setType(r100);
        return;
    }

    @Override // com.bytedance.android.live.base.model.message.c5
    public void setUserValue(i5 r100) {
        c5 r101 = this.f545241tp;
        if (r101 == null) goto L6;
        r101.setUserValue(r100);
        return;
    }

    public final void setVerticalOffset(int r100) {
        this.verticalOffset = r100;
    }

    public c(c5 r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "text");
        this(r100);
        this.text = r101;
    }
}
