package com.bytedance.ies.lynx.lynx_adapter.wrapper;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.lang.reflect.Method;
import java.util.HashMap;
import kotlin.Metadata;
import o46.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0006\u0010\tJ\u0092\u0001\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\u0092\u0001\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH&J\b\u0010 \u001a\u00020\u001dH&J\u0012\u0010\"\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\u0003H&J\b\u0010#\u001a\u00020\u001dH&J\b\u0010$\u001a\u00020\u001dH&J\b\u0010%\u001a\u00020\u001dH&R\u001c\u0010+\u001a\u00020&8&@&X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R8\u00104\u001a\u001e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,j\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.`/8&@&X¦\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u00109\u001a\u00028\u00008&@&X¦\u000e¢\u0006\f\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u0010>\u001a\u00020\n8&@&X¦\u000e¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006?"}, d2 = {"Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxUIWrapper;", "Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "createView", "(Landroid/content/Context;)Landroid/view/View;", "param", "(Landroid/content/Context;Ljava/lang/Object;)Landroid/view/View;", "", "left", "top", "width", "height", "paddingLeft", "paddingTop", "paddingRight", "paddingBottom", "marginLeft", "marginTop", "marginRight", "marginBottom", "borderLeftWidth", "borderTopWidth", "borderRightWidth", "borderBottomWidth", "Landroid/graphics/Rect;", "bound", "", "updateLayout", "updateLayoutInfo", "onLayoutUpdated", ControlRule.KEY_EXTRA_DATA, "updateExtraData", "onAttach", "onDetach", "initialize", "Lo46/a;", "getMPropSetter", "()Lo46/a;", "setMPropSetter", "(Lo46/a;)V", "mPropSetter", "Ljava/util/HashMap;", "", "Ljava/lang/reflect/Method;", "Lkotlin/collections/HashMap;", "getMUIMethods", "()Ljava/util/HashMap;", "setMUIMethods", "(Ljava/util/HashMap;)V", "mUIMethods", "getMInnerView", "()Landroid/view/View;", "setMInnerView", "(Landroid/view/View;)V", "mInnerView", "getSign", "()I", "setSign", "(I)V", "sign", "lynx-adapter_release"}, k = 1, mv = {1, 4, 0})
public interface LynxUIWrapper<T extends View> {
    T createView(Context r100);

    T createView(Context r100, Object r101);

    T getMInnerView();

    a getMPropSetter();

    HashMap<String, Method> getMUIMethods();

    int getSign();

    void initialize();

    void onAttach();

    void onDetach();

    void onLayoutUpdated();

    void setMInnerView(T r100);

    void setMPropSetter(a r100);

    void setMUIMethods(HashMap<String, Method> r100);

    void setSign(int r100);

    void updateExtraData(Object r100);

    void updateLayout(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110, int r111, int r112, int r113, int r114, int r115, int r116, Rect r117);

    void updateLayoutInfo(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108, int r110, int r111, int r112, int r113, int r114, int r115, int r116, Rect r117);
}
