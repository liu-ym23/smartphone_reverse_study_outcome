package com.ss.android.lark.biz.officesdk.im.message.menu;

import android.graphics.Point;
import android.view.View;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import kotlin.Metadata;
import y6b.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J$\u0010\n\u001a\u00020\u000b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u0010\u001a\u00020\u000f2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/message/menu/IDoubaoTextSelectService;", "Lcom/ss/android/lark/officesdk/api/base/IOfficeSDKProtocol;", "supportSelectText", "", "messageVo", "Lcom/ss/android/lark/chat/vo/AbsMessageVO;", "itemView", "Landroid/view/View;", "touchPointOnWindow", "Landroid/graphics/Point;", "startSelectText", "", "getSelectedTextRectOnWindow", "Landroid/graphics/Rect;", "getSelectedText", "", "getAllText", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoubaoTextSelectService extends IOfficeSDKProtocol {
    CharSequence G1(a<?> r100, View r101);

    CharSequence O0(a<?> r100, View r101);

    void Y(a r100, View r101, Point r102);

    void a1(a<?> r100, View r101, Point r102);
}
