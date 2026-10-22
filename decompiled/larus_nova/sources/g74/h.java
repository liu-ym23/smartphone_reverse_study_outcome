package g74;

import android.graphics.Typeface;
import com.baidu.mapapi.map.TextPathMarker;
import com.baidu.mapapi.model.LatLng;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.ITextPath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements ITextPath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextPathMarker f480237a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f480238b;

    @Override // com.bytedance.map.api.model.ITextPath
    public final List<BDLatLng> getPoints() {
        TextPathMarker r100 = this.f480237a;
        if (r100 == null) goto L18;
        List<LatLng> r101 = r100.getPoints();
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.isEmpty() == true) goto L26;
        ArrayList r102 = new ArrayList();
        Iterator<LatLng> r103 = r101.iterator();
    L10:
        if (r103.hasNext() == false) goto L16;
        LatLng r104 = r103.next();
        if (r104 == null) goto L10;
        r102.add(new BDLatLng(r104.latitude, r104.longitude));
        goto L10
    L16:
        if (r102.isEmpty() == true) goto L27;
        return r102;
    L27:
        return null;
    L26:
        return null;
    L18:
        return null;
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final String getText() {
        TextPathMarker r100 = this.f480237a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getText();
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final int getTextBorderColor() {
        TextPathMarker r100 = this.f480237a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getTextBorderColor();
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final int getTextBorderWidth() {
        TextPathMarker r100 = this.f480237a;
        if (r100 == null) goto L9;
        int r101 = r100.getTextBorderWidth();
        int r102 = e74.a.b();
        if (r102 != 0) goto L8;
        return r101;
    L8:
        return Math.round((r101 * r102) / 310.0f);
    L9:
        return 0;
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final int getTextColor() {
        TextPathMarker r100 = this.f480237a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getTextColor();
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final int getTextSize() {
        TextPathMarker r100 = this.f480237a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getTextSize();
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final Typeface getTypeface() {
        TextPathMarker r100 = this.f480237a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getTextFontOption();
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final float getZIndex() {
        TextPathMarker r100 = this.f480237a;
        if (r100 != null) goto L5;
        return 0.0f;
    L5:
        return r100.getZIndex();
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final void remove() {
        TextPathMarker r100 = this.f480237a;
        if (r100 == null) goto L6;
        r100.remove();
        return;
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final String getId() {
        return this.f480238b;
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final void setPoints(List<BDLatLng> r100) {
        if (this.f480237a == null) goto L23;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isEmpty() == true) goto L25;
        ArrayList r101 = new ArrayList();
        Iterator<BDLatLng> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L15;
        BDLatLng r103 = r102.next();
        if (r103 == null) goto L9;
        r101.add(new LatLng(r103.getLatitude(), r103.getLongitude()));
        goto L9
    L15:
        if (r101.isEmpty() == true) goto L26;
        this.f480237a.setPoints(r101);
        return;
    L26:
        return;
    L25:
        return;
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final void setText(String r100) {
        TextPathMarker r101 = this.f480237a;
        if (r101 == null) goto L6;
        r101.setText(r100);
        return;
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final void setTextBorderColor(int r100) {
        TextPathMarker r101 = this.f480237a;
        if (r101 == null) goto L6;
        r101.setTextBorderColor(r100);
        return;
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final void setTextBorderWidth(int r100) {
        TextPathMarker r101 = this.f480237a;
        if (r101 == null) goto L6;
        r101.setTextBorderWidth(e74.a.a(r100));
        return;
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final void setTextColor(int r100) {
        TextPathMarker r101 = this.f480237a;
        if (r101 == null) goto L6;
        r101.setTextColor(r100);
        return;
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final void setTextSize(int r100) {
        TextPathMarker r101 = this.f480237a;
        if (r101 == null) goto L6;
        r101.setTextSize(r100);
        return;
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final void setTypeface(Typeface r100) {
        TextPathMarker r101 = this.f480237a;
        if (r101 == null) goto L6;
        r101.setTextFontOption(r100);
        return;
    }

    @Override // com.bytedance.map.api.model.ITextPath
    public final void setZIndex(float r100) {
        TextPathMarker r101 = this.f480237a;
        if (r101 == null) goto L6;
        r101.setZIndex((int) r100);
        return;
    }

    public h(TextPathMarker r100, String r101) {
        this.f480237a = r100;
        this.f480238b = r101;
    }
}
