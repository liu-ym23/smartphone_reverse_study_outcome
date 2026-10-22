package gs9;

import androidx.lifecycle.LiveData;
import com.larus.platform.api.creation.UserCreation;
import com.larus.profile.api.bean.UserCreationModel;
import java.util.List;

/* JADX INFO: loaded from: classes31.dex */
public interface e {
    void checkLoadMore();

    void deleteUserCreation(String r100, boolean r101);

    LiveData<List<UserCreationModel>> getFeedDataLiveData();

    LiveData<i> getMoreState();

    void updateCreationContent(UserCreation r100);

    void updateCreationModelPrivacy(int r100, boolean r101, UserCreation r102, boolean r103);
}
