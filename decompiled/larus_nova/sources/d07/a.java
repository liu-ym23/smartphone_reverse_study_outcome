package d07;

import com.bytedance.map.api.animation.AnimationStyle;
import com.bytedance.map.api.model.BDMarkerOptions;
import com.bytedance.map.api.model.IMarker;
import com.lynx.react.bridge.ReadableMap;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public interface a {
    IMarker addMarker(BDMarkerOptions r100, boolean r101);

    BDMarkerOptions genMarkerOptions(ReadableMap r100, float r101, float r102, boolean r103);

    List<AnimationStyle> parseAnimationStyle(ReadableMap r100);

    void removeMarker(IMarker r100, boolean r101);

    void startMarkerAnimation(IMarker r100, List<AnimationStyle> r101);
}
