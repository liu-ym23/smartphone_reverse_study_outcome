package zn8;

import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;

/* JADX INFO: loaded from: classes26.dex */
public interface a {
    MarkdownSourceImageView getCiciSourceIcon();

    ViewGroup getContentView();

    SimpleDraweeView getCoverView();

    SimpleDraweeView getDySourceLabelView();

    TextView getTitleView();

    TextView getTvImageCaption();

    int getWidgetHeight();

    int getWidgetWidth();
}
